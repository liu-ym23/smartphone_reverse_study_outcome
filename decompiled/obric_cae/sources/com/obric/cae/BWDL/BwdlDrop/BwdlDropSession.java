package com.obric.cae.BWDL.BwdlDrop;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.BWDL.BwdlDrop.fileTransmission.FileReceiver;
import com.obric.cae.BWDL.BwdlDrop.fileTransmission.FileTransfer;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropShareItem;
import com.obric.cae.log.CaeLog;
import defpackage.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropSession implements Parcelable {
    public static final Parcelable.Creator<BwdlDropSession> CREATOR = null;
    private static final String TAG = "BwdlDropSession";
    private final AtomicBoolean isCancelled;
    private List<BwdlDropSessionObserver> mBwdlDropSessionObserverList;
    private Context mContext;
    private BwdlDropDeviceManager mDeviceManager;
    private int mDirection;
    private BwdlDropEventHandler mEventHandler;
    private ExecutorService mExecutor;
    private int mFileCount;
    private FileReceiver mFileReceiver;
    private long mFileTotalSize;
    private FileTransfer mFileTransfer;
    private boolean mMultipleFlag;
    private String mRemoteDeviceMac;
    private String mRemoteDeviceName;
    private List<BwdlDropShareItem> mShareItemList;
    private final AtomicInteger mState;
    private int mStatus;
    private long mTimestamp;
    private long mTransferSize;

    static {
        CREATOR = new AnonymousClass1();
    }

    public BwdlDropSession(Context r8, List<BwdlDropShareItem> r10, int r11, long r12) {
        this.mShareItemList = new CopyOnWriteArrayList();
        this.mBwdlDropSessionObserverList = new CopyOnWriteArrayList();
        this.mExecutor = Executors.newSingleThreadExecutor();
        this.isCancelled = new AtomicBoolean(false);
        this.mState = new AtomicInteger(1);
        if (r10.size() <= 1) goto L5;
        this.mMultipleFlag = true;
    L6:
        this.mContext = r8;
        this.mShareItemList = r10;
        this.mFileCount = r11;
        this.mFileTotalSize = r12;
        if (this.mBwdlDropSessionObserverList.size() <= 0) goto L10;
        this.mBwdlDropSessionObserverList.clear();
        return;
    L10:
        return;
    L5:
        this.mMultipleFlag = false;
        goto L6
    }

    public static /* synthetic */ int access$000(BwdlDropSession r8) {
        return r8.mDirection;
    }

    public static /* synthetic */ FileReceiver access$100(BwdlDropSession r8) {
        return r8.mFileReceiver;
    }

    public static /* synthetic */ FileReceiver access$102(BwdlDropSession r8, FileReceiver r10) {
        r8.mFileReceiver = r10;
        return r10;
    }

    public static /* synthetic */ BwdlDropDeviceManager access$200(BwdlDropSession r8) {
        return r8.mDeviceManager;
    }

    public static /* synthetic */ FileTransfer access$300(BwdlDropSession r8) {
        return r8.mFileTransfer;
    }

    public static /* synthetic */ FileTransfer access$302(BwdlDropSession r8, FileTransfer r10) {
        r8.mFileTransfer = r10;
        return r10;
    }

    public void cancel() {
        CaeLog.d(TAG, "interrupt transfer");
        this.isCancelled.set(true);
        this.mExecutor.shutdown();
        if (this.mDirection != 0) goto L6;
        BwdlDropEventHandler r8 = BwdlDropManager.getInstance(this.mContext).getEventHandler();
        this.mEventHandler = r8;
        r8.sendMessageDelay(11, this.mDeviceManager.getDataLink(), 2000);
        return;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BwdlDropDeviceManager getDeviceManager() {
        return this.mDeviceManager;
    }

    public int getDirection() {
        return this.mDirection;
    }

    public int getFileCount() {
        return this.mFileCount;
    }

    public long getFileTotalSize() {
        return this.mFileTotalSize;
    }

    public boolean getMultipleFlag() {
        return this.mMultipleFlag;
    }

    public String getRemoteDeviceMac() {
        return this.mRemoteDeviceMac;
    }

    public String getRemoteDeviceName() {
        return this.mRemoteDeviceName;
    }

    public List<BwdlDropShareItem> getShareItemList() {
        return this.mShareItemList;
    }

    public int getState() {
        return this.mState.get();
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public long getTransferSize() {
        return this.mTransferSize;
    }

    public boolean isCancel() {
        return this.isCancelled.get();
    }

    public void notifyObserversProgressChanged(long r8) {
        this.mTransferSize = r8;
        Iterator<BwdlDropSessionObserver> r10 = this.mBwdlDropSessionObserverList.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onTransferProgressChanged(this.mTransferSize);
        goto L4
    }

    public void notifyObserversStatusChange(int r8) {
        b.m("notifyObserversStatusChange:", r8, TAG);
        this.mStatus = r8;
        Iterator<BwdlDropSessionObserver> r10 = this.mBwdlDropSessionObserverList.iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        r10.next().onStatusChanged(this.mDeviceManager, this.mStatus);
        goto L4
    L7:
        if (r8 == 5) goto L11;
        if (r8 == 4) goto L11;
        return;
    L11:
        if (this.mDirection != 0) goto L16;
        BwdlDropEventHandler r11 = BwdlDropManager.getInstance(this.mContext).getEventHandler();
        this.mEventHandler = r11;
        r11.sendMessageDelay(11, this.mDeviceManager.getDataLink(), 2000);
        this.mExecutor.shutdown();
        return;
    }

    public void registerBwdlSessionObserver(BwdlDropSessionObserver r8) {
        if (this.mBwdlDropSessionObserverList.contains(r8) == true) goto L6;
        this.mBwdlDropSessionObserverList.add(r8);
        r8.onStatusChanged(this.mDeviceManager, this.mStatus);
        return;
    }

    public void setBwdlDropDeviceManager(BwdlDropDeviceManager r8) {
        this.mDeviceManager = r8;
    }

    public void setDirection(int r8) {
        this.mDirection = r8;
    }

    public void setRemoteDeviceInfo(String r8, String r10) {
        this.mRemoteDeviceMac = r8;
        this.mRemoteDeviceName = r10;
        this.mTimestamp = System.currentTimeMillis();
    }

    public void setShareItemList(List<BwdlDropShareItem> r8) {
        this.mShareItemList = r8;
    }

    public void setState(int r8) {
        this.mState.set(r8);
        CaeLog.d(TAG, "setState:" + r8);
    }

    public void setStatus(int r8) {
        this.mStatus = r8;
    }

    public void startTransfer(final Context r8) {
        CaeLog.d(TAG, "startTransfer");
        this.mExecutor.execute(new AnonymousClass2(this, r8));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        CaeLog.d(TAG, "RejectedExecutionException");
    }

    public void unRegisterBwdlSessionObserver(BwdlDropSessionObserver r8) {
        if (this.mBwdlDropSessionObserverList.contains(r8) != true) goto L6;
        this.mBwdlDropSessionObserverList.remove(r8);
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeBoolean(this.mMultipleFlag);
        r8.writeInt(this.mFileCount);
        r8.writeLong(this.mFileTotalSize);
        r8.writeInt(this.mDirection);
        r8.writeInt(this.mStatus);
        r8.writeLong(this.mTransferSize);
        r8.writeString(this.mRemoteDeviceMac);
        r8.writeString(this.mRemoteDeviceName);
        r8.writeLong(this.mTimestamp);
        r8.writeInt(this.mShareItemList.size());
        Iterator<BwdlDropShareItem> r11 = this.mShareItemList.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r8.writeParcelable(r11.next(), 0);
        goto L4
    }

    public BwdlDropSession(Parcel r8) {
        this.mShareItemList = new CopyOnWriteArrayList();
        this.mBwdlDropSessionObserverList = new CopyOnWriteArrayList();
        this.mExecutor = Executors.newSingleThreadExecutor();
        int r10 = 0;
        this.isCancelled = new AtomicBoolean(false);
        this.mState = new AtomicInteger(1);
        this.mMultipleFlag = r8.readBoolean();
        this.mFileCount = r8.readInt();
        this.mFileTotalSize = r8.readLong();
        this.mDirection = r8.readInt();
        this.mStatus = r8.readInt();
        this.mTransferSize = r8.readLong();
        this.mRemoteDeviceMac = r8.readString();
        this.mRemoteDeviceName = r8.readString();
        this.mTimestamp = r8.readLong();
        int r11 = r8.readInt();
        if (r11 < 0) goto L6;
    L4:
        if (r10 >= r11) goto L8;
        BwdlDropShareItem r12 = (BwdlDropShareItem) r8.readParcelable(BwdlDropShareItem.class.getClassLoader());
        this.mShareItemList.add(r12);
        r10 = r10 + 1;
        goto L4
    L8:
        return;
    }
}
