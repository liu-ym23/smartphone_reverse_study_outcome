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

    public CursorLoader(@NonNull Context r5) {
        super(r5);
        this.mObserver = new Loader.ForceLoadContentObserver(this);
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        monitor-enter(this);
        CancellationSignal r5 = this.mCancellationSignal;     // Catch: Throwable -> L7
        if (r5 == null) goto L9;
        r5.cancel();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.loader.content.Loader
    public /* bridge */ /* synthetic */ void deliverResult(Object r5) {
        deliverResult((Cursor) r5);
    }

    @Override // androidx.loader.content.AsyncTaskLoader, androidx.loader.content.Loader
    @Deprecated
    public void dump(String r5, FileDescriptor r10, PrintWriter r11, String[] r12) {
        super.dump(r5, r10, r11, r12);
        r11.print(r5);
        r11.print("mUri=");
        r11.println(this.mUri);
        r11.print(r5);
        r11.print("mProjection=");
        r11.println(Arrays.toString(this.mProjection));
        r11.print(r5);
        r11.print("mSelection=");
        r11.println(this.mSelection);
        r11.print(r5);
        r11.print("mSelectionArgs=");
        r11.println(Arrays.toString(this.mSelectionArgs));
        r11.print(r5);
        r11.print("mSortOrder=");
        r11.println(this.mSortOrder);
        r11.print(r5);
        r11.print("mCursor=");
        r11.println(this.mCursor);
        r11.print(r5);
        r11.print("mContentChanged=");
        r11.println(this.mContentChanged);
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

    @Override // androidx.loader.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ Cursor loadInBackground() {
        return loadInBackground();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ void onCanceled(Cursor r5) {
        onCanceled2(r5);
    }

    @Override // androidx.loader.content.Loader
    public void onReset() {
        super.onReset();
        onStopLoading();
        Cursor r5 = this.mCursor;
        if (r5 != null) goto L5;
    L7:
        this.mCursor = null;
        return;
    L5:
        if (r5.isClosed() == true) goto L7;
        this.mCursor.close();
        goto L7
    }

    @Override // androidx.loader.content.Loader
    public void onStartLoading() {
        Cursor r5 = this.mCursor;
        if (r5 == null) goto L6;
        deliverResult(r5);
    L6:
        if (takeContentChanged() == false) goto L8;
    L9:
        forceLoad();
        return;
    L8:
        if (this.mCursor == null) goto L9;
    }

    @Override // androidx.loader.content.Loader
    public void onStopLoading() {
        cancelLoad();
    }

    public void setProjection(@Nullable String[] r5) {
        this.mProjection = r5;
    }

    public void setSelection(@Nullable String r5) {
        this.mSelection = r5;
    }

    public void setSelectionArgs(@Nullable String[] r5) {
        this.mSelectionArgs = r5;
    }

    public void setSortOrder(@Nullable String r5) {
        this.mSortOrder = r5;
    }

    public void setUri(@NonNull Uri r5) {
        this.mUri = r5;
    }

    public void deliverResult(Cursor r5) {
        if (isReset() == false) goto L7;
        if (r5 == null) goto L16;
        r5.close();
        return;
    L16:
        return;
    L7:
        Cursor r10 = this.mCursor;
        this.mCursor = r5;
        if (isStarted() == false) goto L10;
        super.deliverResult(r5);
    L10:
        if (r10 == null) goto L17;
        if (r10 != r5) goto L13;
        return;
    L13:
        if (r10.isClosed() == true) goto L19;
        r10.close();
        return;
    L19:
        return;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L4:
        if (isLoadInBackgroundCanceled() == true) goto L34;
        this.mCancellationSignal = new CancellationSignal();     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        Cursor r5 = ContentResolverCompat.query(getContext().getContentResolver(), this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder, this.mCancellationSignal);     // Catch: Throwable -> L12
        if (r5 != null) goto L37;
    L17:
        monitor-enter(this);
        this.mCancellationSignal = null;     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return r5;
    L21:
        th = move-exception;
        throw th;
    L37:
        r5.getCount();     // Catch: Throwable -> L12 RuntimeException -> L14
        r5.registerContentObserver(this.mObserver);     // Catch: Throwable -> L12 RuntimeException -> L14
    L14:
        e = move-exception;
        r5.close();     // Catch: Throwable -> L12
        throw e;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        monitor-enter(this);
        this.mCancellationSignal = null;     // Catch: Throwable -> L28
        throw th;
    L28:
        th = move-exception;
        throw th;
    L34:
        throw new OperationCanceledException();     // Catch: Throwable -> L31
    }

    /* JADX INFO: renamed from: onCanceled, reason: avoid collision after fix types in other method */
    public void onCanceled2(Cursor r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isClosed() == true) goto L8;
        r5.close();
        return;
    }

    public CursorLoader(@NonNull Context r5, @NonNull Uri r10, @Nullable String[] r11, @Nullable String r12, @Nullable String[] r13, @Nullable String r14) {
        super(r5);
        this.mObserver = new Loader.ForceLoadContentObserver(this);
        this.mUri = r10;
        this.mProjection = r11;
        this.mSelection = r12;
        this.mSelectionArgs = r13;
        this.mSortOrder = r14;
    }
}
