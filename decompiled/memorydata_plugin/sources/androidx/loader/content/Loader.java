package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.core.util.DebugUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class Loader<D> {
    boolean mAbandoned;
    boolean mContentChanged;
    Context mContext;
    int mId;
    OnLoadCompleteListener<D> mListener;
    OnLoadCanceledListener<D> mOnLoadCanceledListener;
    boolean mProcessingChange;
    boolean mReset;
    boolean mStarted;

    public final class ForceLoadContentObserver extends ContentObserver {
        final /* synthetic */ Loader this$0;

        public ForceLoadContentObserver(Loader r1) {
            this.this$0 = r1;
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1) {
            this.this$0.onContentChanged();
        }
    }

    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(Loader<D> r1);
    }

    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(Loader<D> r1, D r2);
    }

    public Loader(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.mStarted = false;
        this.mAbandoned = false;
        this.mReset = true;
        this.mContentChanged = false;
        this.mProcessingChange = false;
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public String dataToString(D r2) {
        StringBuilder r1 = new StringBuilder(64);
        DebugUtils.buildShortClassTag(r2, r1);
        r1.append("}");
        return r1.toString();
    }

    public void deliverCancellation() {
        OnLoadCanceledListener<D> r0 = this.mOnLoadCanceledListener;
        if (r0 == null) goto L6;
        r0.onLoadCanceled(this);
        return;
    }

    public void deliverResult(D r2) {
        OnLoadCompleteListener<D> r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onLoadComplete(this, r2);
        return;
    }

    @Deprecated
    public void dump(String r1, FileDescriptor r2, PrintWriter r3, String[] r4) {
        r3.print(r1);
        r3.print("mId=");
        r3.print(this.mId);
        r3.print(" mListener=");
        r3.println(this.mListener);
        if (this.mStarted == false) goto L5;
    L8:
        r3.print(r1);
        r3.print("mStarted=");
        r3.print(this.mStarted);
        r3.print(" mContentChanged=");
        r3.print(this.mContentChanged);
        r3.print(" mProcessingChange=");
        r3.println(this.mProcessingChange);
    L10:
        if (this.mAbandoned == false) goto L12;
    L13:
        r3.print(r1);
        r3.print("mAbandoned=");
        r3.print(this.mAbandoned);
        r3.print(" mReset=");
        r3.println(this.mReset);
        return;
    L12:
        if (this.mReset == true) goto L13;
        return;
    L5:
        if (this.mContentChanged == true) goto L8;
        if (this.mProcessingChange == false) goto L10;
        goto L8
    }

    public void forceLoad() {
        onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void onAbandon() {
    }

    public boolean onCancelLoad() {
        return false;
    }

    public void onContentChanged() {
        if (this.mStarted == false) goto L5;
        forceLoad();
        return;
    L5:
        this.mContentChanged = true;
    }

    public void onForceLoad() {
    }

    public void onReset() {
    }

    public void onStartLoading() {
    }

    public void onStopLoading() {
    }

    public void registerListener(int r3, OnLoadCompleteListener<D> r4) {
        OnLoadCompleteListener<D> r5 = (OnLoadCompleteListener) ZeusTransformUtils.wrapperContextForParams(r4, OnLoadCompleteListener.class, "com.obric.memorydata.plugin");
        if (this.mListener != null) goto L7;
        this.mListener = r5;
        this.mId = r3;
        return;
    L7:
        throw new IllegalStateException("There is already a listener registered");
    }

    public void registerOnLoadCanceledListener(OnLoadCanceledListener<D> r3) {
        OnLoadCanceledListener<D> r4 = (OnLoadCanceledListener) ZeusTransformUtils.wrapperContextForParams(r3, OnLoadCanceledListener.class, "com.obric.memorydata.plugin");
        if (this.mOnLoadCanceledListener != null) goto L7;
        this.mOnLoadCanceledListener = r4;
        return;
    L7:
        throw new IllegalStateException("There is already a listener registered");
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange == false) goto L6;
        onContentChanged();
        return;
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean r0 = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= r0;
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, r0);
        r0.append(" id=");
        r0.append(this.mId);
        r0.append("}");
        return r0.toString();
    }

    public void unregisterListener(OnLoadCompleteListener<D> r3) {
        OnLoadCompleteListener<D> r4 = (OnLoadCompleteListener) ZeusTransformUtils.wrapperContextForParams(r3, OnLoadCompleteListener.class, "com.obric.memorydata.plugin");
        OnLoadCompleteListener<D> r0 = this.mListener;
        if (r0 == null) goto L10;
        if (r0 != r4) goto L8;
        this.mListener = null;
        return;
    L8:
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    L10:
        throw new IllegalStateException("No listener register");
    }

    public void unregisterOnLoadCanceledListener(OnLoadCanceledListener<D> r3) {
        OnLoadCanceledListener<D> r4 = (OnLoadCanceledListener) ZeusTransformUtils.wrapperContextForParams(r3, OnLoadCanceledListener.class, "com.obric.memorydata.plugin");
        OnLoadCanceledListener<D> r0 = this.mOnLoadCanceledListener;
        if (r0 == null) goto L10;
        if (r0 != r4) goto L8;
        this.mOnLoadCanceledListener = null;
        return;
    L8:
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    L10:
        throw new IllegalStateException("No listener register");
    }
}
