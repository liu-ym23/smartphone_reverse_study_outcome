package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
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

    /* JADX INFO: renamed from: androidx.core.view.inputmethod.InputConnectionCompat$2, reason: invalid class name */
    public class AnonymousClass2 extends InputConnectionWrapper {
        final /* synthetic */ OnCommitContentListener val$listener;

        public AnonymousClass2(InputConnection r5, boolean r10, OnCommitContentListener r11) {
            this.val$listener = r11;
            super(r5, r10);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(String r5, Bundle r10) {
            if (InputConnectionCompat.handlePerformPrivateCommand(r5, r10, this.val$listener) == false) goto L7;
            return true;
        L7:
            return super.performPrivateCommand(r5, r10);
        }
    }

    @RequiresApi(25)
    public static class Api25Impl {
        private Api25Impl() {
        }

        @DoNotInline
        public static boolean commitContent(InputConnection r5, InputContentInfo r10, int r11, Bundle r12) {
            return r5.commitContent(r10, r11, r12);
        }
    }

    public interface OnCommitContentListener {
        boolean onCommitContent(@NonNull InputContentInfoCompat r5, int r10, @Nullable Bundle r11);
    }

    @Deprecated
    public InputConnectionCompat() {
    }

    public static /* synthetic */ boolean a(View r5, InputContentInfoCompat r10, int r11, Bundle r12) {
        return lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(r5, r10, r11, r12);
    }

    public static boolean commitContent(@NonNull InputConnection r5, @NonNull EditorInfo r10, @NonNull InputContentInfoCompat r11, int r12, @Nullable Bundle r13) {
        return Api25Impl.commitContent(r5, (InputContentInfo) r11.unwrap(), r12, r13);
    }

    @NonNull
    private static OnCommitContentListener createOnCommitContentListenerUsingPerformReceiveContent(@NonNull View r5) {
        Preconditions.checkNotNull(r5);
        return new a(r5, 0);
    }

    @NonNull
    @Deprecated
    public static InputConnection createWrapper(@NonNull final InputConnection r5, @NonNull EditorInfo r10, @NonNull final OnCommitContentListener r11) {
        ObjectsCompat.requireNonNull(r5, "inputConnection must be non-null");
        ObjectsCompat.requireNonNull(r10, "editorInfo must be non-null");
        ObjectsCompat.requireNonNull(r11, "onCommitContentListener must be non-null");
        final boolean r12 = false;
        return new AnonymousClass1(r5, r12, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static boolean handlePerformPrivateCommand(@Nullable String r10, @Nullable Bundle r11, @NonNull OnCommitContentListener r12) {
        ?? r5 = 0;
        r5 = 0;
        if (r11 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(COMMIT_CONTENT_ACTION, r10) == false) goto L9;
        boolean r13 = false;
    L12:
        if (r13 == false) goto L16;
        String r14 = COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY;
    L52:
        ResultReceiver r15 = (ResultReceiver) r11.getParcelable(r14);     // Catch: Throwable -> L14
        if (r13 == false) goto L22;
        String r16 = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
    L50:
        Uri r17 = (Uri) r11.getParcelable(r16);     // Catch: Throwable -> L20
        if (r13 == false) goto L26;
        String r18 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
    L27:
        ClipDescription r19 = (ClipDescription) r11.getParcelable(r18);     // Catch: Throwable -> L20
        if (r13 == false) goto L30;
        String r20 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
    L31:
        Uri r21 = (Uri) r11.getParcelable(r20);     // Catch: Throwable -> L20
        if (r13 == false) goto L34;
        String r22 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
    L35:
        int r23 = r11.getInt(r22);     // Catch: Throwable -> L20
        if (r13 == false) goto L38;
        String r24 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
    L39:
        Bundle r25 = (Bundle) r11.getParcelable(r24);     // Catch: Throwable -> L20
        if (r17 == null) goto L43;
        if (r19 == null) goto L43;
        r5 = r12.onCommitContent(new InputContentInfoCompat(r17, r19, r21), r23, r25);     // Catch: Throwable -> L20
    L43:
        if (r15 == 0) goto L45;
        r15.send(r5, null);
    L45:
        return r5;
    L38:
        r24 = COMMIT_CONTENT_OPTS_KEY;
        goto L39
    L34:
        r22 = COMMIT_CONTENT_FLAGS_KEY;
        goto L35
    L30:
        r20 = COMMIT_CONTENT_LINK_URI_KEY;
        goto L31
    L26:
        r18 = COMMIT_CONTENT_DESCRIPTION_KEY;
    L20:
        th = th;
        ResultReceiver r26 = r15;
    L46:
        if (r26 == null) goto L48;
        r26.send(0, null);
    L48:
        throw th;
    L22:
        r16 = COMMIT_CONTENT_CONTENT_URI_KEY;
    L14:
        th = th;
        r26 = null;
        goto L46
    L16:
        r14 = COMMIT_CONTENT_RESULT_RECEIVER_KEY;
        goto L52
    L9:
        if (TextUtils.equals(COMMIT_CONTENT_INTEROP_ACTION, r10) == false) goto L49;
        r13 = true;
        goto L12
    L49:
        return false;
    }

    private static /* synthetic */ boolean lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(View r5, InputContentInfoCompat r10, int r11, Bundle r12) {
        if ((r11 & 1) == 0) goto L14;
        r10.requestPermission();     // Catch: Exception -> L10
        Parcelable r13 = (Parcelable) r10.unwrap();
        if (r12 != null) goto L8;
        r12 = new Bundle();
    L9:
        r12.putParcelable(EXTRA_INPUT_CONTENT_INFO, r13);
        goto L14
    L8:
        r12 = new Bundle(r12);
    L10:
        e = move-exception;
        Log.w(LOG_TAG, "Can't insert content from IME; requestPermission() failed", e);
        return false;
    L14:
        if (ViewCompat.performReceiveContent(r5, new ContentInfoCompat.Builder(new ClipData(r10.getDescription(), new ClipData.Item(r10.getContentUri())), 2).setLinkUri(r10.getLinkUri()).setExtras(r12).build()) != null) goto L17;
        return true;
    L17:
        return false;
    }

    @NonNull
    public static InputConnection createWrapper(@NonNull View r5, @NonNull InputConnection r10, @NonNull EditorInfo r11) {
        return createWrapper(r10, r11, createOnCommitContentListenerUsingPerformReceiveContent(r5));
    }
}
