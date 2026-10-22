package androidx.core.view.inputmethod;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class InputConnectionCompat {
    private static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;
    private static final String LOG_TAG = "InputConnectionCompat";

    static class Api25Impl {
        private Api25Impl() {
        }

        static boolean commitContent(InputConnection r2, InputContentInfo r3, int r4, Bundle r5) {
            return ((InputConnection) ZeusTransformUtils.wrapperContextForParams(r2, InputConnection.class, "com.obric.memorydata.plugin")).commitContent(r3, r4, r5);
        }
    }

    public interface OnCommitContentListener {
        boolean onCommitContent(InputContentInfoCompat r1, int r2, Bundle r3);
    }

    @Deprecated
    public InputConnectionCompat() {
    }

    public static boolean commitContent(InputConnection r3, EditorInfo r4, InputContentInfoCompat r5, int r6, Bundle r7) {
        InputConnection r8 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r3, InputConnection.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 25) goto L5;
        int r9 = EditorInfoCompat.getProtocol(r4);
        boolean r1 = false;
        if (r9 != 2) goto L9;
        r1 = true;
    L14:
        Bundle r10 = new Bundle();
        if (r1 == false) goto L17;
        String r0 = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
    L18:
        r10.putParcelable(r0, r5.getContentUri());
        if (r1 == false) goto L21;
        String r2 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
    L22:
        r10.putParcelable(r2, r5.getDescription());
        if (r1 == false) goto L25;
        String r11 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
    L26:
        r10.putParcelable(r11, r5.getLinkUri());
        if (r1 == false) goto L29;
        String r12 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
    L30:
        r10.putInt(r12, r6);
        if (r1 == false) goto L33;
        String r13 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
    L34:
        r10.putParcelable(r13, r7);
        if (r1 == false) goto L37;
        String r14 = COMMIT_CONTENT_INTEROP_ACTION;
    L39:
        return r8.performPrivateCommand(r14, r10);
    L37:
        r14 = COMMIT_CONTENT_ACTION;
        goto L39
    L33:
        r13 = COMMIT_CONTENT_OPTS_KEY;
        goto L34
    L29:
        r12 = COMMIT_CONTENT_FLAGS_KEY;
        goto L30
    L25:
        r11 = COMMIT_CONTENT_LINK_URI_KEY;
        goto L26
    L21:
        r2 = COMMIT_CONTENT_DESCRIPTION_KEY;
        goto L22
    L17:
        r0 = COMMIT_CONTENT_CONTENT_URI_KEY;
        goto L18
    L9:
        if (r9 == 3) goto L14;
        if (r9 == 4) goto L14;
        return false;
    L5:
        return Api25Impl.commitContent(r8, (InputContentInfo) ZeusTransformUtils.preCheckCast(r5.unwrap(), InputContentInfo.class, "com.obric.memorydata.plugin"), r6, r7);
    }

    private static OnCommitContentListener createOnCommitContentListenerUsingPerformReceiveContent(final View r1) {
        Preconditions.checkNotNull(r1);
        return new $$Lambda$InputConnectionCompat$KpUNHX7G_3SrNfrFIzMfcFEp1Cw(r1);
    }

    public static InputConnection createWrapper(View r2, InputConnection r3, EditorInfo r4) {
        return createWrapper((InputConnection) ZeusTransformUtils.wrapperContextForParams(r3, InputConnection.class, "com.obric.memorydata.plugin"), r4, createOnCommitContentListenerUsingPerformReceiveContent(r2));
    }

    @Deprecated
    public static InputConnection createWrapper(InputConnection r3, EditorInfo r4, OnCommitContentListener r5) {
        final InputConnection r6 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r3, InputConnection.class, "com.obric.memorydata.plugin");
        final OnCommitContentListener r7 = (OnCommitContentListener) ZeusTransformUtils.wrapperContextForParams(r5, OnCommitContentListener.class, "com.obric.memorydata.plugin");
        ObjectsCompat.requireNonNull(r6, "inputConnection must be non-null");
        ObjectsCompat.requireNonNull(r4, "editorInfo must be non-null");
        ObjectsCompat.requireNonNull(r7, "onCommitContentListener must be non-null");
        final boolean r1 = false;
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return new AnonymousClass1(r6, r1, r7);
    L7:
        if (EditorInfoCompat.getContentMimeTypes(r4).length != 0) goto L10;
        return r6;
    L10:
        return new AnonymousClass2(r6, r1, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    static boolean handlePerformPrivateCommand(String r8, Bundle r9, OnCommitContentListener r10) {
        OnCommitContentListener r11 = (OnCommitContentListener) ZeusTransformUtils.wrapperContextForParams(r10, OnCommitContentListener.class, "com.obric.memorydata.plugin");
        ?? r0 = 0;
        r0 = 0;
        if (r9 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(COMMIT_CONTENT_ACTION, r8) == false) goto L9;
        boolean r12 = false;
    L12:
        if (r12 == false) goto L14;
        String r3 = COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY;
    L50:
        ResultReceiver r4 = (ResultReceiver) ZeusTransformUtils.preCheckCast(r9.getParcelable(r3), ResultReceiver.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (r12 == false) goto L18;
        String r5 = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
    L52:
        Uri r6 = (Uri) ZeusTransformUtils.preCheckCast(r9.getParcelable(r5), Uri.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        if (r12 == false) goto L22;
        String r7 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
    L23:
        ClipDescription r13 = (ClipDescription) ZeusTransformUtils.preCheckCast(r9.getParcelable(r7), ClipDescription.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        if (r12 == false) goto L26;
        String r14 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
    L27:
        Uri r15 = (Uri) ZeusTransformUtils.preCheckCast(r9.getParcelable(r14), Uri.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        if (r12 == false) goto L30;
        String r16 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
    L31:
        int r17 = r9.getInt(r16);     // Catch: Throwable -> L42
        if (r12 == false) goto L34;
        String r18 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
    L35:
        Bundle r19 = (Bundle) ZeusTransformUtils.preCheckCast(r9.getParcelable(r18), Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        if (r6 == null) goto L39;
        if (r13 == null) goto L39;
        r0 = r11.onCommitContent(new InputContentInfoCompat(r6, r13, r15), r17, r19);     // Catch: Throwable -> L42
    L39:
        if (r4 == 0) goto L41;
        r4.send(r0, null);
    L41:
        return r0;
    L34:
        r18 = COMMIT_CONTENT_OPTS_KEY;
        goto L35
    L30:
        r16 = COMMIT_CONTENT_FLAGS_KEY;
        goto L31
    L26:
        r14 = COMMIT_CONTENT_LINK_URI_KEY;
        goto L27
    L22:
        r7 = COMMIT_CONTENT_DESCRIPTION_KEY;
    L42:
        th = th;
    L46:
        if (r4 == 0) goto L48;
        r4.send(0, null);
    L48:
        throw th;
    L18:
        r5 = COMMIT_CONTENT_CONTENT_URI_KEY;
    L44:
        th = th;
        r4 = 0;
        goto L46
    L14:
        r3 = COMMIT_CONTENT_RESULT_RECEIVER_KEY;
        goto L50
    L9:
        if (TextUtils.equals(COMMIT_CONTENT_INTEROP_ACTION, r8) == false) goto L49;
        r12 = true;
        goto L12
    L49:
        return false;
    }

    static /* synthetic */ boolean lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(View r5, InputContentInfoCompat r6, int r7, Bundle r8) {
        if (Build.VERSION.SDK_INT < 25) goto L16;
        if ((r7 & 1) == 0) goto L16;
        r6.requestPermission();     // Catch: Exception -> L12
        Parcelable r9 = (Parcelable) ZeusTransformUtils.preCheckCast(r6.unwrap(), Parcelable.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L10;
        r8 = new Bundle();
    L11:
        r8.putParcelable(EXTRA_INPUT_CONTENT_INFO, r9);
        goto L16
    L10:
        r8 = new Bundle(r8);
    L12:
        e = move-exception;
        Log.w(LOG_TAG, "Can't insert content from IME; requestPermission() failed", e);
        return false;
    L16:
        if (ViewCompat.performReceiveContent(r5, new ContentInfoCompat.Builder(new ClipData(r6.getDescription(), new ClipData.Item(r6.getContentUri())), 2).setLinkUri(r6.getLinkUri()).setExtras(r8).build()) == null) goto L18;
        return false;
    L18:
        return true;
    }
}
