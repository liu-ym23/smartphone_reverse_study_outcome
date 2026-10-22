package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.DebugUtils;
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

        public ForceLoadContentObserver(Loader r10) {
            this.this$0 = r10;
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r10) {
            this.this$0.onContentChanged();
        }
    }

    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(@NonNull Loader<D> r10);
    }

    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(@NonNull Loader<D> r10, @Nullable D r11);
    }

    public Loader(@NonNull Context r10) {
        this.mStarted = false;
        this.mAbandoned = false;
        this.mReset = true;
        this.mContentChanged = false;
        this.mProcessingChange = false;
        this.mContext = r10.getApplicationContext();
    }

    @MainThread
    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    @MainThread
    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    @NonNull
    public String dataToString(@Nullable D r10) {
        StringBuilder r11 = new StringBuilder(64);
        DebugUtils.buildShortClassTag(r10, r11);
        r11.append("}");
        return r11.toString();
    }

    @MainThread
    public void deliverCancellation() {
        OnLoadCanceledListener<D> r10 = this.mOnLoadCanceledListener;
        if (r10 == null) goto L6;
        r10.onLoadCanceled(this);
        return;
    }

    @MainThread
    public void deliverResult(@Nullable D r10) {
        OnLoadCompleteListener<D> r11 = this.mListener;
        if (r11 == null) goto L6;
        r11.onLoadComplete(this, r10);
        return;
    }

    @Deprecated
    public void dump(String r10, FileDescriptor r11, PrintWriter r12, String[] r13) {
        r12.print(r10);
        r12.print("mId=");
        r12.print(this.mId);
        r12.print(" mListener=");
        r12.println(this.mListener);
        if (this.mStarted == false) goto L5;
    L8:
        r12.print(r10);
        r12.print("mStarted=");
        r12.print(this.mStarted);
        r12.print(" mContentChanged=");
        r12.print(this.mContentChanged);
        r12.print(" mProcessingChange=");
        r12.println(this.mProcessingChange);
    L10:
        if (this.mAbandoned == false) goto L12;
    L13:
        r12.print(r10);
        r12.print("mAbandoned=");
        r12.print(this.mAbandoned);
        r12.print(" mReset=");
        r12.println(this.mReset);
        return;
    L12:
        if (this.mReset == true) goto L13;
        return;
    L5:
        if (this.mContentChanged == true) goto L8;
        if (this.mProcessingChange == false) goto L10;
        goto L8
    }

    @MainThread
    public void forceLoad() {
        onForceLoad();
    }

    @NonNull
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

    @MainThread
    protected void onAbandon() {
    }

    @MainThread
    protected boolean onCancelLoad() {
        return false;
    }

    @MainThread
    public void onContentChanged() {
        if (this.mStarted == false) goto L5;
        forceLoad();
        return;
    L5:
        this.mContentChanged = true;
    }

    @MainThread
    protected void onForceLoad() {
    }

    @MainThread
    protected void onReset() {
    }

    @MainThread
    protected void onStartLoading() {
    }

    @MainThread
    protected void onStopLoading() {
    }

    @MainThread
    public void registerListener(int r10, @NonNull OnLoadCompleteListener<D> r11) {
        if (this.mListener != null) goto L7;
        this.mListener = r11;
        this.mId = r10;
        return;
    L7:
        throw new IllegalStateException("There is already a listener registered");
    }

    @MainThread
    public void registerOnLoadCanceledListener(@NonNull OnLoadCanceledListener<D> r10) {
        if (this.mOnLoadCanceledListener != null) goto L7;
        this.mOnLoadCanceledListener = r10;
        return;
    L7:
        throw new IllegalStateException("There is already a listener registered");
    }

    @MainThread
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

    @MainThread
    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    @MainThread
    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean r10 = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= r10;
        return r10;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, r10);
        r10.append(" id=");
        r10.append(this.mId);
        r10.append("}");
        return r10.toString();
    }

    @MainThread
    public void unregisterListener(@NonNull OnLoadCompleteListener<D> r10) {
        OnLoadCompleteListener<D> r11 = this.mListener;
        if (r11 == null) goto L10;
        if (r11 != r10) goto L8;
        this.mListener = null;
        return;
    L8:
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    L10:
        throw new IllegalStateException("No listener register");
    }

    @MainThread
    public void unregisterOnLoadCanceledListener(@NonNull OnLoadCanceledListener<D> r10) {
        OnLoadCanceledListener<D> r11 = this.mOnLoadCanceledListener;
        if (r11 == null) goto L10;
        if (r11 != r10) goto L8;
        this.mOnLoadCanceledListener = null;
        return;
    L8:
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    L10:
        throw new IllegalStateException("No listener register");
    }
}
