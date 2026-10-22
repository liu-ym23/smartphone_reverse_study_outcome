package com.ss.android.lark.keyboard.edittext;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.DragEvent;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.UIUtils;
import com.larus.feishu.office.im.impl.officemention.OfficeMentionServiceImpl;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.biz.mention.FetchAllDataAtStrategy;
import com.ss.android.lark.keyboard.biz.mention.IMCommonAtStrategy;
import com.ss.android.lark.keyboard.editor.input.l;
import com.ss.android.lark.keyboard.editor.input.m;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.customlink.CustomLinkStrategy;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.UrlInlinePreviewConfig;
import com.ss.android.lark.keyboard.edittext2.edittors.image.ImageEditor;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.keyboard.edittext2.list.EditorListApplier;
import com.ss.android.lark.keyboard.edittext2.span.ClickLinkMovementMethod;
import com.ss.android.lark.keyboard.edittext2.utils.RichTextCopyUtils;
import com.ss.android.lark.keyboard.viewmodel.KeyboardModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0003`abB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\b2\b\b\u0002\u00106\u001a\u00020\bJ\u0016\u00107\u001a\u00020\u00122\u0006\u00108\u001a\u00020\fH\u0096@¢\u0006\u0002\u00109J\u0016\u0010:\u001a\u00020\u00122\u0006\u00108\u001a\u00020\fH\u0096@¢\u0006\u0002\u00109J\u0010\u0010;\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010<J\u0017\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010%H\u0000¢\u0006\u0002\b@J\u0010\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020\u0012H\u0014J\u0010\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u00020\bH\u0014J\b\u0010G\u001a\u00020>H\u0002J\b\u0010H\u001a\u00020>H\u0002J\b\u0010I\u001a\u00020>H\u0002J\b\u0010J\u001a\u00020>H\u0002J\b\u0010K\u001a\u00020>H\u0002J\b\u0010L\u001a\u00020>H\u0002J\b\u0010M\u001a\u00020>H\u0002J\b\u0010N\u001a\u00020>H\u0014J\b\u0010O\u001a\u00020>H\u0014J\u0010\u0010P\u001a\u00020>2\b\u0010Q\u001a\u0004\u0018\u00010!J\u0010\u0010R\u001a\u00020>2\b\u0010Q\u001a\u0004\u0018\u00010#J\u0010\u0010S\u001a\u00020>2\b\u0010T\u001a\u0004\u0018\u00010'J\u0006\u0010U\u001a\u00020>J\u0016\u0010V\u001a\u00020>2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020XJ\b\u0010Z\u001a\u00020>H\u0002J\u0012\u0010[\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0002J\b\u0010^\u001a\u00020>H\u0002J\b\u0010_\u001a\u00020>H\u0002R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b0\u00101¨\u0006c"}, d2 = {"Lcom/ss/android/lark/keyboard/edittext/FlowKeyboardFunctionEditText;", "Lcom/ss/android/lark/keyboard/edittext2/KeyboardFunctionEditText;", "Lcom/ss/android/lark/keyboard/edittext/IMarkdownInputContent;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "curChatId", "", "getCurChatId", "()Ljava/lang/String;", "setCurChatId", "(Ljava/lang/String;)V", "curChatIsPrivate", "", "getCurChatIsPrivate", "()Z", "setCurChatIsPrivate", "(Z)V", "htmlClipCoordinator", "Lcom/ss/android/lark/keyboard/edittext/FunctionEditTextCopyCoordinator;", "localImagePasteCoordinator", "Lcom/ss/android/lark/keyboard/edittext/KeyboardLocalImagePasteCoordinator;", "richTextPasteCoordinator", "Lcom/ss/android/lark/keyboard/edittext/KeyboardRichTextPasteCoordinator;", "editTextController", "", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/v2/IEditTextController;", "onPasteImageListener", "Lcom/ss/android/lark/keyboard/edittext/FlowKeyboardFunctionEditText$OnPasteImageListener;", "onPasteUriListener", "Lcom/ss/android/lark/keyboard/edittext/FlowKeyboardFunctionEditText$OnPasteUriListener;", "dragEventHandler", "Lcom/ss/android/lark/keyboard/edittext/FlowKeyboardDragEventHandler;", "urlInlinePreviewConfig", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/urlinline/UrlInlinePreviewConfig;", "keyboardModel", "Lcom/ss/android/lark/keyboard/viewmodel/KeyboardModel;", "getKeyboardModel", "()Lcom/ss/android/lark/keyboard/viewmodel/KeyboardModel;", "keyboardModel$delegate", "Lkotlin/Lazy;", "markdownInputContentDelegate", "Lcom/ss/android/lark/keyboard/edittext/MarkdownInputContentDelegate;", "getMarkdownInputContentDelegate", "()Lcom/ss/android/lark/keyboard/edittext/MarkdownInputContentDelegate;", "markdownInputContentDelegate$delegate", "getRichText", "Lcom/ss/android/lark/widget/richtext/RichText;", "start", "end", "setMarkdownContent", "markdown", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appendMarkdownContent", "getMarkdownContent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDragEventHandler", "", "handler", "setDragEventHandler$keyboard_assembler_productionChinaRelease", "onDragEvent", "event", "Landroid/view/DragEvent;", "beforeTextPaste", "beforeTextCopy", "id", "setupIMImageAndMedia", "setupListApplier", "setupIMRichTextEditor", "setupIMRichTextGenerator", "setupAnchorStrategies", "setupAtEditor", "setupInlineCodeApplier", "onAttachedToWindow", "onDetachedFromWindow", "setOnPasteImageListener", "listener", "setOnPasteUriListener", "setUrlInlinePreviewConfig", "config", "useLarkUrlInlinePreview", "useLarkTempPreview", "appId", "", "type", "setupTextSelection", "handleAfterTextChangeForController", "editable", "Landroid/text/Editable;", "setupAnchorV2", "setupRichTextEditor", "Companion", "OnPasteImageListener", "OnPasteUriListener", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowKeyboardFunctionEditText extends KeyboardFunctionEditText {
    public static final /* synthetic */ int v = 0;
    public String k;
    public boolean l;
    public final com.ss.android.lark.keyboard.edittext.b m;
    public final com.ss.android.lark.keyboard.edittext.d n;
    public final com.ss.android.lark.keyboard.edittext.e o;
    public final List<com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2.c> p;
    public c q;
    public com.ss.android.lark.keyboard.edittext.a r;
    public UrlInlinePreviewConfig s;
    public final Lazy t;
    public final Lazy u;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
        boolean a(List<? extends Uri> r1);
    }

    public static final class d implements TextWatcher {
        public final /* synthetic */ FlowKeyboardFunctionEditText a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public d(FlowKeyboardFunctionEditText r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            FlowKeyboardFunctionEditText r0 = this.a;
            int r1 = FlowKeyboardFunctionEditText.v;
            r0.getClass();
            Log.d("FlowKeyboardFunctionEditText", "handleAfterTextChangeForController");
            Iterator r2 = ((ArrayList) r0.p).iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            ((com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2.c) r2.next()).afterTextChanged(r4);
            goto L4
        }
    }

    public static final class e implements TextWatcher {
        public final /* synthetic */ FlowKeyboardFunctionEditText a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public e(FlowKeyboardFunctionEditText r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            if (Build.VERSION.SDK_INT < 26) goto L6;
            this.a.setDefaultFocusHighlightEnabled(false);
            return;
        }
    }

    static {
    }

    public FlowKeyboardFunctionEditText(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FlowKeyboardFunctionEditText(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setOnPasteImageListener(b r1) {
    }

    private final KeyboardModel getKeyboardModel() {
        return (KeyboardModel) this.t.getValue();
    }

    private final f getMarkdownInputContentDelegate() {
        return (f) this.u.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText
    public final boolean f() {
        ClipData r1 = RichTextCopyUtils.d(getContext());
        boolean r2 = false;
        if (r1 != null) goto L5;
        return false;
    L5:
        final com.ss.android.lark.keyboard.edittext.e r3 = this.o;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "clp");
        final Ref.BooleanRef r5 = new Ref.BooleanRef();
        final b r7 = null;
        RichTextCopyUtils.h(r1, new KeyboardRichTextPasteCoordinator$handleRichTextClipIfNeed$1(r3, r7, r5));
        if (r5.element == true) goto L97;
        com.ss.android.lark.keyboard.edittext.b r9 = this.m;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "clipData");
        Log.i("FunctionEditTextCopyCoordinator", "handleClipDataIfNeed");
        if (r9.c == true) goto L10;
    L9:
        boolean r4 = false;
    L23:
        if (r4 == true) goto L97;
        com.ss.android.lark.keyboard.edittext.d r6 = this.n;
        c r8 = this.q;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "clp");
        if (r8 != null) goto L27;
    L26:
        boolean r10 = false;
    L54:
        if (r10 == true) goto L97;
        com.ss.android.lark.keyboard.edittext.d r11 = this.n;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r1, "clp");
        Context r12 = r11.a.getContext();
        Intrinsics.checkNotNull(r12);
        new HashMap();
        int r13 = StoragePermissionUtils.a(r12, StoragePermissionUtils.d(r12, 2));
        StoragePermissionUtils.a(r12, StoragePermissionUtils.d(r12, 4));
        StoragePermissionUtils.d(r12, 8);
        StoragePermissionUtils.e(r12);
        if (r13 == 2) goto L58;
        boolean r14 = true;
    L59:
        if (r14 == true) goto L62;
        Log.i("KeyboardLocalImagePasteCoordinator", "handleClipUriIfNeed: no storage permission");
    L61:
        boolean r15 = false;
    L96:
        if (r15 == true) goto L97;
    L98:
        Log.d("FlowKeyboardFunctionEditText", "beforeTextPaste " + r2);
        return r2;
    L62:
        int r16 = 0;
    L64:
        if (r16 >= r1.getDescription().getMimeTypeCount()) goto L72;
        String r17 = r1.getDescription().getMimeType(r16);
        if (Intrinsics.areEqual(r17, "text/uri-list") == true) goto L70;
        Intrinsics.checkNotNull(r17);
        if (StringsKt.startsWith$default(r17, "image/", false, 2, null) == true) goto L70;
        r16 = r16 + 1;
    L70:
        boolean r18 = true;
    L73:
        if (r18 == false) goto L61;
        int r19 = 0;
    L77:
        if (r19 >= r1.getItemCount()) goto L86;
        ClipData.Item r20 = r1.getItemAt(r19);
        Uri r110 = r20.getUri();
        if (r110 == null) goto L81;
        String r111 = r110.getScheme();
    L83:
        if (TextUtils.equals("content", r111) == true) goto L84;
        r19 = r19 + 1;
        goto L77
    L84:
        Uri r112 = r20.getUri();
    L87:
        if (r112 == null) goto L61;
        ContentResolver r113 = r12.getContentResolver();
        sf7.a r21 = sf7.a.a;
        Intrinsics.checkNotNull(r113);
        final Cursor r22 = r21.query(r113, r112, new String[]{"_id", "_data", "mime_type", "width", "height", "_size"}, null, null, null, new Token("LARK-PSDA-paste_local_img_query_content"));
        if (r22 == null) goto L61;
        BuildersKt.launch$default(r11.b, null, null, new KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$job$1(r11, r22, null, null), 3, null).invokeOnCompletion(new KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$1(r22));
        Editable r23 = r11.a.getText();
        if (r23 == null) goto L95;
        r23.append("\u200b");
        r23.delete(r23.length() - 1, r23.length());
    L95:
        r15 = true;
        goto L96
    L81:
        r111 = null;
        goto L83
    L86:
        r112 = null;
        goto L87
    L72:
        r18 = false;
        goto L73
    L58:
        r14 = false;
        goto L59
    L27:
        int r114 = r1.getDescription().getMimeTypeCount();
        int r115 = 0;
    L28:
        if (r115 >= r114) goto L36;
        String r116 = r1.getDescription().getMimeType(r115);
        if (Intrinsics.areEqual(r116, "text/uri-list") == true) goto L35;
        Intrinsics.checkNotNull(r116);
        if (StringsKt.startsWith$default(r116, "image/", false, 2, null) == true) goto L35;
        r115 = r115 + 1;
    L35:
        boolean r117 = true;
    L37:
        if (r117 == false) goto L26;
        ArrayList r118 = new ArrayList();
        int r119 = r1.getItemCount();
        int r120 = 0;
    L40:
        if (r120 >= r119) goto L51;
        Uri r121 = r1.getItemAt(r120).getUri();
        if (r121 == null) goto L49;
        if (TextUtils.equals("content", r121.getScheme()) == true) goto L47;
        r121 = null;
    L47:
        if (r121 == null) goto L49;
        r118.add(r121);
    L49:
        r120 = r120 + 1;
        goto L40
    L51:
        if (r118.isEmpty() == true) goto L26;
        r10 = r8.a(r118);
        goto L54
    L36:
        r117 = false;
        goto L37
    L10:
        ClipData.Item r24 = r1.getItemAt(0);
        if (r24 == null) goto L9;
        String r122 = r24.getHtmlText();
        if (r122 != null) goto L16;
    L19:
        boolean r25 = true;
    L20:
        if (r25 == true) goto L9;
        CharSequence r123 = r24.getText();
        Log.i("FunctionEditTextCopyCoordinator", "handleClipDataIfNeed: html is not empty, trying to transform html to richText");
        Log.d("FunctionEditTextCopyCoordinator", "htmlToRichText: html is " + r122);
        BuildersKt.launch$default(r9.d, null, null, new FunctionEditTextCopyCoordinator$handleClipDataIfNeed$1(r9, r122, r123, null, null), 3, null);
        r4 = true;
        goto L23
    L16:
        if (r122.length() == 0) goto L19;
        r25 = false;
    L97:
        r2 = true;
        goto L98
    }

    public final void k() {
        ArrayList r0 = new ArrayList();
        r0.add(com.ss.android.lark.keyboard.edittext2.edittors.anchor.tasklink.b.a);
        r0.add(CustomLinkStrategy.b);
        r0.add(com.ss.android.lark.keyboard.edittext2.edittors.anchor.possiblelink.b.a);
        r0.add(new com.ss.android.lark.keyboard.edittext2.edittors.anchor.widecharurl.a(this.s));
        ((eob.a) q(eob.a.f)).Y(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.EditText*/.onAttachedToWindow();
        Iterator<T> r0 = this.p.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2.c) r0.next()).b(this);
        goto L4
    L6:
        this.m.c = true;
        this.o.getClass();
        this.n.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.EditText*/.onDetachedFromWindow();
        Iterator<T> r0 = this.p.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2.c) r0.next()).unbind();
        goto L4
    L6:
        com.ss.android.lark.keyboard.edittext.b r1 = this.m;
        r1.c = false;
        CoroutineScopeKt.cancel$default(r1.d, null, 1, null);
        CoroutineScopeKt.cancel$default(this.n.b, null, 1, null);
        CoroutineScopeKt.cancel$default(this.o.b, null, 1, null);
    }

    public final String getCurChatId() {
        return this.k;
    }

    public final boolean getCurChatIsPrivate() {
        return this.l;
    }

    public static final /* synthetic */ KeyboardModel h(FlowKeyboardFunctionEditText r0) {
        return r0.getKeyboardModel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static RichText i(FlowKeyboardFunctionEditText r2) {
        int r0 = r2.length();
        return ((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) com.ss.android.lark.keyboard.edittext2.utils.e.a(r2.q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g), FlowKeyboardFunctionEditText$getRichText$1.INSTANCE)).i(0, r0);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText
    public final boolean e(int r10) {
        com.ss.android.lark.keyboard.edittext.b r0 = this.m;
        if (r0.c == true) goto L5;
        boolean r1 = false;
    L6:
        if (r1 == false) goto L8;
        return false;
    L8:
        return super.e(r10);
    L5:
        BuildersKt.launch$default(r0.d, null, null, new FunctionEditTextCopyCoordinator$asyncWriteRichTextHtmlIfNeed$1(r0, null), 3, null);
        r1 = true;
        goto L6
    }

    public final boolean onDragEvent(DragEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.r == null) goto L6;
        Handler r0 = OfficeMentionServiceImpl.b;
        Intrinsics.checkNotNullParameter(r2, "it");
        return false;
    L6:
        return super.onDragEvent(r2);
    }

    public final void setCurChatId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k = r2;
    }

    public final void setCurChatIsPrivate(boolean r1) {
        this.l = r1;
    }

    public final void setDragEventHandler$keyboard_assembler_productionChinaRelease(com.ss.android.lark.keyboard.edittext.a r1) {
        this.r = r1;
    }

    public final void setOnPasteUriListener(c r1) {
        this.q = r1;
    }

    public final void setUrlInlinePreviewConfig(UrlInlinePreviewConfig r1) {
        if (r1 != null) goto L4;
        int r2 = UrlInlinePreviewConfig.b;
        r1 = UrlInlinePreviewConfig.a.a();
    L4:
        this.s = r1;
        k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKeyboardFunctionEditText(final Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.k = "";
        this.m = new com.ss.android.lark.keyboard.edittext.b(this);
        this.n = new com.ss.android.lark.keyboard.edittext.d(this);
        this.o = new com.ss.android.lark.keyboard.edittext.e(this);
        this.p = new ArrayList();
        int r6 = UrlInlinePreviewConfig.b;
        this.s = UrlInlinePreviewConfig.a.a();
        this.t = LazyKt.lazy(FlowKeyboardFunctionEditText$keyboardModel$2.INSTANCE);
        this.u = LazyKt.lazy(new FlowKeyboardFunctionEditText$markdownInputContentDelegate$2(this, r3));
        addTextChangedListener(new e(this));
        addTextChangedListener(new d(this));
        setHighlightColor(UIUtils.getAlphaColor(2131105548, 0.2d));
        k();
        RichTextEditor.a r7 = RichTextEditor.t;
        q(r7);
        d(dob.b.class);
        com.ss.android.lark.keyboard.edittext2.edittors.a.C0137a r8 = com.ss.android.lark.keyboard.edittext2.edittors.a.e;
        q(r8);
        d(dob.a.class);
        setMovementMethod(new ClickLinkMovementMethod(this));
        ArrayList r9 = new ArrayList();
        r9.add(new FetchAllDataAtStrategy(new FlowKeyboardFunctionEditText$setupAtEditor$1(this)));
        r9.add(new IMCommonAtStrategy(new FlowKeyboardFunctionEditText$setupAtEditor$2(this)));
        ((com.ss.android.lark.keyboard.edittext2.edittors.a) q(r8)).W(r9);
        q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g);
        d(dob.c.class);
        q(r7);
        d(dob.b.class);
        EditorListApplier r10 = new EditorListApplier(this, new com.ss.android.lark.keyboard.edittext2.list.b(getContext()));
        r10.b();
        EditorListApplier.b r11 = new EditorListApplier.b(r10);
        Intrinsics.checkNotNullParameter(r11, "onKeyListener");
        this.i.add(r11);
        q(com.ss.android.lark.keyboard.edittext2.edittors.e.e);
        d(m.class);
        q(ImageEditor.c);
        d(l.class);
        ((RichTextEditor) q(r7)).j = true;
    }

    public /* synthetic */ FlowKeyboardFunctionEditText(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
