package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.a;
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

        public ForceLoadContentObserver(Loader r5) {
            this.this$0 = r5;
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r5) {
            this.this$0.onContentChanged();
        }
    }

    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(@NonNull Loader<D> r5);
    }

    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(@NonNull Loader<D> r5, @Nullable D r10);
    }

    public Loader(@NonNull Context r5) {
        this.mStarted = false;
        this.mAbandoned = false;
        this.mReset = true;
        this.mContentChanged = false;
        this.mProcessingChange = false;
        this.mContext = r5.getApplicationContext();
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
    public String dataToString(@Nullable D r5) {
        StringBuilder r10 = new StringBuilder(64);
        DebugUtils.buildShortClassTag(r5, r10);
        r10.append("}");
        return r10.toString();
    }

    @MainThread
    public void deliverCancellation() {
        OnLoadCanceledListener<D> r5 = this.mOnLoadCanceledListener;
        if (r5 == null) goto L6;
        r5.onLoadCanceled(this);
        return;
    }

    @MainThread
    public void deliverResult(@Nullable D r5) {
        OnLoadCompleteListener<D> r10 = this.mListener;
        if (r10 == null) goto L6;
        r10.onLoadComplete(this, r5);
        return;
    }

    @Deprecated
    public void dump(String r5, FileDescriptor r10, PrintWriter r11, String[] r12) {
        r11.print(r5);
        r11.print("mId=");
        r11.print(this.mId);
        r11.print(" mListener=");
        r11.println(this.mListener);
        if (this.mStarted == false) goto L5;
    L8:
        r11.print(r5);
        r11.print("mStarted=");
        r11.print(this.mStarted);
        r11.print(" mContentChanged=");
        r11.print(this.mContentChanged);
        r11.print(" mProcessingChange=");
        r11.println(this.mProcessingChange);
    L10:
        if (this.mAbandoned == false) goto L12;
    L13:
        r11.print(r5);
        r11.print("mAbandoned=");
        r11.print(this.mAbandoned);
        r11.print(" mReset=");
        r11.println(this.mReset);
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
    public void onAbandon() {
    }

    @MainThread
    public boolean onCancelLoad() {
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
    public void onForceLoad() {
    }

    @MainThread
    public void onReset() {
    }

    @MainThread
    public void onStartLoading() {
    }

    @MainThread
    public void onStopLoading() {
    }

    @MainThread
    public void registerListener(int r5, @NonNull OnLoadCompleteListener<D> r10) {
        if (this.mListener != null) goto L7;
        this.mListener = r10;
        this.mId = r5;
        return;
    L7:
        throw new IllegalStateException("There is already a listener registered");
    }

    @MainThread
    public void registerOnLoadCanceledListener(@NonNull OnLoadCanceledListener<D> r5) {
        if (this.mOnLoadCanceledListener != null) goto L7;
        this.mOnLoadCanceledListener = r5;
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
        boolean r5 = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= r5;
        return r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, r5);
        r5.append(" id=");
        return a.s(r5, this.mId, "}");
    }

    @MainThread
    public void unregisterListener(@NonNull OnLoadCompleteListener<D> r5) {
        OnLoadCompleteListener<D> r10 = this.mListener;
        if (r10 == null) goto L10;
        if (r10 != r5) goto L8;
        this.mListener = null;
        return;
    L8:
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    L10:
        throw new IllegalStateException("No listener register");
    }

    @MainThread
    public void unregisterOnLoadCanceledListener(@NonNull OnLoadCanceledListener<D> r5) {
        OnLoadCanceledListener<D> r10 = this.mOnLoadCanceledListener;
        if (r10 == null) goto L10;
        if (r10 != r5) goto L8;
        this.mOnLoadCanceledListener = null;
        return;
    L8:
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    L10:
        throw new IllegalStateException("No listener register");
    }
}
