package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CursorLoader extends AsyncTaskLoader<Cursor> {
    CancellationSignal mCancellationSignal;
    Cursor mCursor;
    final Loader<Cursor>.ForceLoadContentObserver mObserver;
    String[] mProjection;
    String mSelection;
    String[] mSelectionArgs;
    String mSortOrder;
    Uri mUri;

    public CursorLoader(@NonNull Context r10) {
        super(r10);
        this.mObserver = new Loader.ForceLoadContentObserver(this);
    }

    public CursorLoader(@NonNull Context r10, @NonNull Uri r11, @Nullable String[] r12, @Nullable String r13, @Nullable String[] r14, @Nullable String r15) {
        super(r10);
        this.mObserver = new Loader.ForceLoadContentObserver(this);
        this.mUri = r11;
        this.mProjection = r12;
        this.mSelection = r13;
        this.mSelectionArgs = r14;
        this.mSortOrder = r15;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        monitor-enter(this);
        CancellationSignal r10 = this.mCancellationSignal;     // Catch: Throwable -> L9
        if (r10 == null) goto L7;
        r10.cancel();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void deliverResult(Cursor r10) {
        if (isReset() == false) goto L7;
        if (r10 == null) goto L16;
        r10.close();
        return;
    L16:
        return;
    L7:
        Cursor r11 = this.mCursor;
        this.mCursor = r10;
        if (isStarted() == false) goto L10;
        super.deliverResult(r10);
    L10:
        if (r11 == null) goto L17;
        if (r11 != r10) goto L13;
        return;
    L13:
        if (r11.isClosed() == true) goto L19;
        r11.close();
        return;
    L19:
        return;
    }

    @Override // androidx.loader.content.Loader
    public /* bridge */ /* synthetic */ void deliverResult(Object r10) {
        deliverResult((Cursor) r10);
    }

    @Override // androidx.loader.content.AsyncTaskLoader, androidx.loader.content.Loader
    @Deprecated
    public void dump(String r10, FileDescriptor r11, PrintWriter r12, String[] r13) {
        super.dump(r10, r11, r12, r13);
        r12.print(r10);
        r12.print("mUri=");
        r12.println(this.mUri);
        r12.print(r10);
        r12.print("mProjection=");
        r12.println(Arrays.toString(this.mProjection));
        r12.print(r10);
        r12.print("mSelection=");
        r12.println(this.mSelection);
        r12.print(r10);
        r12.print("mSelectionArgs=");
        r12.println(Arrays.toString(this.mSelectionArgs));
        r12.print(r10);
        r12.print("mSortOrder=");
        r12.println(this.mSortOrder);
        r12.print(r10);
        r12.print("mCursor=");
        r12.println(this.mCursor);
        r12.print(r10);
        r12.print("mContentChanged=");
        r12.println(this.mContentChanged);
    }

    @Nullable
    public String[] getProjection() {
        return this.mProjection;
    }

    @Nullable
    public String getSelection() {
        return this.mSelection;
    }

    @Nullable
    public String[] getSelectionArgs() {
        return this.mSelectionArgs;
    }

    @Nullable
    public String getSortOrder() {
        return this.mSortOrder;
    }

    @NonNull
    public Uri getUri() {
        return this.mUri;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L4:
        if (isLoadInBackgroundCanceled() == true) goto L31;
        this.mCancellationSignal = new CancellationSignal();     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        Cursor r10 = ContentResolverCompat.query(getContext().getContentResolver(), this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder, this.mCancellationSignal);     // Catch: Throwable -> L22
        if (r10 != null) goto L38;
    L15:
        monitor-enter(this);
        this.mCancellationSignal = null;     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return r10;
    L19:
        th = move-exception;
        throw th;
    L38:
        r10.getCount();     // Catch: RuntimeException -> L12 Throwable -> L22
        r10.registerContentObserver(this.mObserver);     // Catch: RuntimeException -> L12 Throwable -> L22
    L12:
        e = move-exception;
        r10.close();     // Catch: Throwable -> L22
        throw e;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        monitor-enter(this);
        this.mCancellationSignal = null;     // Catch: Throwable -> L27
        throw th;
    L27:
        th = move-exception;
        throw th;
    L31:
        throw new OperationCanceledException();     // Catch: Throwable -> L32
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ Cursor loadInBackground() {
        return loadInBackground();
    }

    /* JADX INFO: renamed from: onCanceled, reason: avoid collision after fix types in other method */
    public void onCanceled2(Cursor r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isClosed() == true) goto L8;
        r10.close();
        return;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ void onCanceled(Cursor r10) {
        onCanceled2(r10);
    }

    @Override // androidx.loader.content.Loader
    protected void onReset() {
        super.onReset();
        onStopLoading();
        Cursor r10 = this.mCursor;
        if (r10 != null) goto L5;
    L7:
        this.mCursor = null;
        return;
    L5:
        if (r10.isClosed() == true) goto L7;
        this.mCursor.close();
        goto L7
    }

    @Override // androidx.loader.content.Loader
    protected void onStartLoading() {
        Cursor r10 = this.mCursor;
        if (r10 == null) goto L6;
        deliverResult(r10);
    L6:
        if (takeContentChanged() == false) goto L8;
    L9:
        forceLoad();
        return;
    L8:
        if (this.mCursor == null) goto L9;
    }

    @Override // androidx.loader.content.Loader
    protected void onStopLoading() {
        cancelLoad();
    }

    public void setProjection(@Nullable String[] r10) {
        this.mProjection = r10;
    }

    public void setSelection(@Nullable String r10) {
        this.mSelection = r10;
    }

    public void setSelectionArgs(@Nullable String[] r10) {
        this.mSelectionArgs = r10;
    }

    public void setSortOrder(@Nullable String r10) {
        this.mSortOrder = r10;
    }

    public void setUri(@NonNull Uri r10) {
        this.mUri = r10;
    }
}
