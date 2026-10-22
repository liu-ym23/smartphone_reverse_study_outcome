package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
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

    @RequiresApi(25)
    static class Api25Impl {
        private Api25Impl() {
        }

        @DoNotInline
        static boolean commitContent(InputConnection r10, InputContentInfo r11, int r12, Bundle r13) {
            return r10.commitContent(r11, r12, r13);
        }
    }

    public interface OnCommitContentListener {
        boolean onCommitContent(@NonNull InputContentInfoCompat r10, int r11, @Nullable Bundle r12);
    }

    @Deprecated
    public InputConnectionCompat() {
    }

    public static /* synthetic */ boolean a(View r10, InputContentInfoCompat r11, int r12, Bundle r13) {
        return lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(r10, r11, r12, r13);
    }

    public static boolean commitContent(@NonNull InputConnection r10, @NonNull EditorInfo r11, @NonNull InputContentInfoCompat r12, int r13, @Nullable Bundle r14) {
        if (Build.VERSION.SDK_INT >= 25) goto L5;
        int r15 = EditorInfoCompat.getProtocol(r11);
        boolean r16 = false;
        if (r15 != 2) goto L9;
        r16 = true;
    L14:
        Bundle r17 = new Bundle();
        if (r16 == false) goto L17;
        String r18 = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
    L18:
        r17.putParcelable(r18, r12.getContentUri());
        if (r16 == false) goto L21;
        String r19 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
    L22:
        r17.putParcelable(r19, r12.getDescription());
        if (r16 == false) goto L25;
        String r20 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
    L26:
        r17.putParcelable(r20, r12.getLinkUri());
        if (r16 == false) goto L29;
        String r21 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
    L30:
        r17.putInt(r21, r13);
        if (r16 == false) goto L33;
        String r22 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
    L34:
        r17.putParcelable(r22, r14);
        if (r16 == false) goto L37;
        String r23 = COMMIT_CONTENT_INTEROP_ACTION;
    L39:
        return r10.performPrivateCommand(r23, r17);
    L37:
        r23 = COMMIT_CONTENT_ACTION;
        goto L39
    L33:
        r22 = COMMIT_CONTENT_OPTS_KEY;
        goto L34
    L29:
        r21 = COMMIT_CONTENT_FLAGS_KEY;
        goto L30
    L25:
        r20 = COMMIT_CONTENT_LINK_URI_KEY;
        goto L26
    L21:
        r19 = COMMIT_CONTENT_DESCRIPTION_KEY;
        goto L22
    L17:
        r18 = COMMIT_CONTENT_CONTENT_URI_KEY;
        goto L18
    L9:
        if (r15 == 3) goto L14;
        if (r15 == 4) goto L14;
        return false;
    L5:
        return Api25Impl.commitContent(r10, (InputContentInfo) r12.unwrap(), r13, r14);
    }

    @NonNull
    private static OnCommitContentListener createOnCommitContentListenerUsingPerformReceiveContent(@NonNull final View r10) {
        Preconditions.checkNotNull(r10);
        return new a(r10);
    }

    @NonNull
    public static InputConnection createWrapper(@NonNull View r10, @NonNull InputConnection r11, @NonNull EditorInfo r12) {
        return createWrapper(r11, r12, createOnCommitContentListenerUsingPerformReceiveContent(r10));
    }

    @NonNull
    @Deprecated
    public static InputConnection createWrapper(@NonNull final InputConnection r10, @NonNull EditorInfo r11, @NonNull final OnCommitContentListener r12) {
        ObjectsCompat.requireNonNull(r10, "inputConnection must be non-null");
        ObjectsCompat.requireNonNull(r11, "editorInfo must be non-null");
        ObjectsCompat.requireNonNull(r12, "onCommitContentListener must be non-null");
        final boolean r13 = false;
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return new AnonymousClass1(r10, r13, r12);
    L7:
        if (EditorInfoCompat.getContentMimeTypes(r11).length != 0) goto L10;
        return r10;
    L10:
        return new AnonymousClass2(r10, r13, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    static boolean handlePerformPrivateCommand(@Nullable String r10, @Nullable Bundle r11, @NonNull OnCommitContentListener r12) {
        ?? r13 = 0;
        r13 = 0;
        if (r11 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(COMMIT_CONTENT_ACTION, r10) == false) goto L9;
        boolean r14 = false;
    L12:
        if (r14 == false) goto L14;
        String r15 = COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY;
    L52:
        ResultReceiver r16 = (ResultReceiver) r11.getParcelable(r15);     // Catch: Throwable -> L44
        if (r14 == false) goto L18;
        String r17 = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
    L50:
        Uri r18 = (Uri) r11.getParcelable(r17);     // Catch: Throwable -> L42
        if (r14 == false) goto L22;
        String r19 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
    L23:
        ClipDescription r20 = (ClipDescription) r11.getParcelable(r19);     // Catch: Throwable -> L42
        if (r14 == false) goto L26;
        String r21 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
    L27:
        Uri r22 = (Uri) r11.getParcelable(r21);     // Catch: Throwable -> L42
        if (r14 == false) goto L30;
        String r23 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
    L31:
        int r24 = r11.getInt(r23);     // Catch: Throwable -> L42
        if (r14 == false) goto L34;
        String r25 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
    L35:
        Bundle r26 = (Bundle) r11.getParcelable(r25);     // Catch: Throwable -> L42
        if (r18 == null) goto L39;
        if (r20 == null) goto L39;
        r13 = r12.onCommitContent(new InputContentInfoCompat(r18, r20, r22), r24, r26);     // Catch: Throwable -> L42
    L39:
        if (r16 == 0) goto L41;
        r16.send(r13, null);
    L41:
        return r13;
    L34:
        r25 = COMMIT_CONTENT_OPTS_KEY;
        goto L35
    L30:
        r23 = COMMIT_CONTENT_FLAGS_KEY;
        goto L31
    L26:
        r21 = COMMIT_CONTENT_LINK_URI_KEY;
        goto L27
    L22:
        r19 = COMMIT_CONTENT_DESCRIPTION_KEY;
    L42:
        th = th;
    L46:
        if (r16 == 0) goto L48;
        r16.send(0, null);
    L48:
        throw th;
    L18:
        r17 = COMMIT_CONTENT_CONTENT_URI_KEY;
    L44:
        th = th;
        r16 = 0;
        goto L46
    L14:
        r15 = COMMIT_CONTENT_RESULT_RECEIVER_KEY;
        goto L52
    L9:
        if (TextUtils.equals(COMMIT_CONTENT_INTEROP_ACTION, r10) == false) goto L49;
        r14 = true;
        goto L12
    L49:
        return false;
    }

    private static /* synthetic */ boolean lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(View r10, InputContentInfoCompat r11, int r12, Bundle r13) {
        if (Build.VERSION.SDK_INT < 25) goto L16;
        if ((r12 & 1) == 0) goto L16;
        r11.requestPermission();     // Catch: Exception -> L12
        InputContentInfo r14 = (InputContentInfo) r11.unwrap();
        if (r13 != null) goto L10;
        r13 = new Bundle();
    L11:
        r13.putParcelable(EXTRA_INPUT_CONTENT_INFO, r14);
        goto L16
    L10:
        r13 = new Bundle(r13);
    L12:
        e = move-exception;
        Log.w(LOG_TAG, "Can't insert content from IME; requestPermission() failed", e);
        return false;
    L16:
        if (ViewCompat.performReceiveContent(r10, new ContentInfoCompat.Builder(new ClipData(r11.getDescription(), new ClipData.Item(r11.getContentUri())), 2).setLinkUri(r11.getLinkUri()).setExtras(r13).build()) == null) goto L18;
        return false;
    L18:
        return true;
    }
}
