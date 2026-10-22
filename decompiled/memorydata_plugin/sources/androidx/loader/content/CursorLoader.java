package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public CursorLoader(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.mObserver = new Loader.ForceLoadContentObserver(this);
    }

    public CursorLoader(Context r3, Uri r4, String[] r5, String r6, String[] r7, String r8) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.mObserver = new Loader.ForceLoadContentObserver(this);
        this.mUri = r4;
        this.mProjection = r5;
        this.mSelection = r6;
        this.mSelectionArgs = r7;
        this.mSortOrder = r8;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        monitor-enter(this);
        CancellationSignal r0 = this.mCancellationSignal;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.cancel();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void deliverResult(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        if (isReset() == false) goto L7;
        if (r4 == null) goto L16;
        r4.close();
        return;
    L16:
        return;
    L7:
        Cursor r0 = this.mCursor;
        this.mCursor = r4;
        if (isStarted() == false) goto L10;
        super.deliverResult(r4);
    L10:
        if (r0 == null) goto L17;
        if (r0 != r4) goto L13;
        return;
    L13:
        if (r0.isClosed() == true) goto L19;
        r0.close();
        return;
    L19:
        return;
    }

    @Override // androidx.loader.content.Loader
    public /* synthetic */ void deliverResult(Object r3) {
        deliverResult((Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.loader.content.AsyncTaskLoader, androidx.loader.content.Loader
    @Deprecated
    public void dump(String r1, FileDescriptor r2, PrintWriter r3, String[] r4) {
        super.dump(r1, r2, r3, r4);
        r3.print(r1);
        r3.print("mUri=");
        r3.println(this.mUri);
        r3.print(r1);
        r3.print("mProjection=");
        r3.println(Arrays.toString(this.mProjection));
        r3.print(r1);
        r3.print("mSelection=");
        r3.println(this.mSelection);
        r3.print(r1);
        r3.print("mSelectionArgs=");
        r3.println(Arrays.toString(this.mSelectionArgs));
        r3.print(r1);
        r3.print("mSortOrder=");
        r3.println(this.mSortOrder);
        r3.print(r1);
        r3.print("mCursor=");
        r3.println(this.mCursor);
        r3.print(r1);
        r3.print("mContentChanged=");
        r3.println(this.mContentChanged);
    }

    public String[] getProjection() {
        return this.mProjection;
    }

    public String getSelection() {
        return this.mSelection;
    }

    public String[] getSelectionArgs() {
        return this.mSelectionArgs;
    }

    public String getSortOrder() {
        return this.mSortOrder;
    }

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
        Cursor r1 = ContentResolverCompat.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder, this.mCancellationSignal);     // Catch: Throwable -> L22
        if (r1 != null) goto L38;
    L15:
        monitor-enter(this);
        this.mCancellationSignal = null;     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return r1;
    L19:
        th = move-exception;
        throw th;
    L38:
        r1.getCount();     // Catch: RuntimeException -> L12 Throwable -> L22
        r1.registerContentObserver(this.mObserver);     // Catch: RuntimeException -> L12 Throwable -> L22
    L12:
        e = move-exception;
        r1.close();     // Catch: Throwable -> L22
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
    public void onCanceled2(Cursor r2) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isClosed() == true) goto L9;
        r1.close();
        return;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public /* synthetic */ void onCanceled(Cursor r3) {
        onCanceled2((Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.loader.content.Loader
    public void onReset() {
        super.onReset();
        onStopLoading();
        Cursor r0 = this.mCursor;
        if (r0 != null) goto L5;
    L7:
        this.mCursor = null;
        return;
    L5:
        if (r0.isClosed() == true) goto L7;
        this.mCursor.close();
        goto L7
    }

    @Override // androidx.loader.content.Loader
    public void onStartLoading() {
        Cursor r0 = this.mCursor;
        if (r0 == null) goto L6;
        deliverResult(r0);
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

    public void setProjection(String[] r1) {
        this.mProjection = r1;
    }

    public void setSelection(String r1) {
        this.mSelection = r1;
    }

    public void setSelectionArgs(String[] r1) {
        this.mSelectionArgs = r1;
    }

    public void setSortOrder(String r1) {
        this.mSortOrder = r1;
    }

    public void setUri(Uri r1) {
        this.mUri = r1;
    }
}
