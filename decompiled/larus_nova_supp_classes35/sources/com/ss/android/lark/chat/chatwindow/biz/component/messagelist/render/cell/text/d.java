package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.lark.pb.basic.v1.File;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FolderContent;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.keyboard.base.ChatAttachmentUploadProgressStore;
import com.ss.android.lark.keyboard.base.ChatAttachmentUploadState;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.a0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final d a = null;

    public static final class a {
        public final boolean a;
        public final MessagePermissionUtil.ReceiveAuthorizationState b;

        public a() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (r0 * 31) + this.b.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "SecurityState(hasPreviewPermission=" + this.a + ", receiveAuthorizationState=" + this.b + ')';
        }

        public /* synthetic */ a(int r2) {
            this(true, MessagePermissionUtil.ReceiveAuthorizationState.NORMAL_STATE);
        }

        public a(boolean r2, MessagePermissionUtil.ReceiveAuthorizationState r3) {
            Intrinsics.checkNotNullParameter(r3, "receiveAuthorizationState");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MessagePermissionUtil.ReceiveAuthorizationState.values().length];
            r0[MessagePermissionUtil.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L21:
            r0[MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L6:
            a = r0;
            int[] r1 = new int[File.Source.values().length];
            r1[File.Source.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L33:
            r1[File.Source.LARK_SERVER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L25:
            r1[File.Source.NUT_STORE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L27:
            r1[File.Source.LAN_TRANS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L11:
            b = r1;
            int[] r2 = new int[ChatAttachmentUploadState.values().length];
            r2[ChatAttachmentUploadState.PROCESSING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    static {
        a = new d();
    }

    public d() {
    }

    public static boolean c(Chat r4) {
        if (r4.isP2PChat() == false) goto L5;
        ChatChatter r0 = ImSdkService.d().H5(r4.getId(), r4.getP2pChatterId());
    L6:
        int r1 = vnb.a.a;
        boolean r2 = false;
        if (r4.isSecret() == true) goto L25;
        if (r4.isGroup() == false) goto L13;
        r2 = FeatureGatingModule.getFeatureGatingService().isEnable("im.message.richtext_file_folder_tag_group");
        goto L25
    L13:
        if (r4.isP2PChat() == false) goto L22;
        if (r0 != null) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r3 == false) goto L22;
        r2 = FeatureGatingModule.getFeatureGatingService().isEnable("im.message.richtext_file_folder_tag_bot");
        goto L25
    L16:
        if (r0.isBot() != true) goto L18;
        r3 = true;
    L22:
        if (r4.isP2PChat() == false) goto L25;
        r2 = FeatureGatingModule.getFeatureGatingService().isEnable("im.message.richtext_file_folder_tag_single");
    L25:
        return !r2;
    L5:
        r0 = null;
        goto L6
    }

    public static int e(File.Source r2) {
        int r3 = b.b[r2.ordinal()];
        if (r3 != 1) goto L5;
        return 0;
    L5:
        if (r3 != 2) goto L7;
        return 1;
    L7:
        if (r3 != 3) goto L9;
        return 2;
    L9:
        if (r3 != 4) goto L12;
        return 3;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static FolderContent f(File r5) {
        FolderContent r0 = new FolderContent();
        String r1 = r5.key;
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        r0.setKey(r1);
        String r2 = r5.name;
        int r3 = 1;
        String r4 = null;
        if (r2 != null) goto L8;
    L12:
        String r6 = r5.key;
        if (r6 != null) goto L15;
    L17:
        if (r4 != null) goto L19;
        r2 = UIHelper.getString(2131891743);
    L20:
        r0.setName(r2);
        Long r7 = r5.size;
        if (r7 == null) goto L23;
        long r8 = r7.longValue();
    L24:
        r0.setSize(r8);
        File.Extra r9 = r5.extra;
        if (r9 == null) goto L29;
        File.Source r10 = r9.source;
        if (r10 == null) goto L29;
        a.getClass();
        r3 = e(r10);
    L29:
        r0.setSource(r3);
        return r0;
    L23:
        r8 = 0;
        goto L24
    L19:
        r2 = r4;
        goto L20
    L15:
        if (Boolean.valueOf(!StringsKt.isBlank(r6)).booleanValue() == false) goto L17;
        r4 = r6;
        goto L17
    L8:
        if (Boolean.valueOf(!StringsKt.isBlank(r2)).booleanValue() == true) goto L11;
        r2 = null;
    L11:
        if (r2 != null) goto L20;
        goto L12
    }

    public static FileContent d(File r7, List r8) {
        FileContent r0 = new FileContent();
        String r1 = r7.key;
        String r2 = BuildConfig.FLAVOR;
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        r0.setKey(r1);
        String r3 = r7.name;
        int r4 = 1;
        ArrayList<String> r5 = null;
        if (r3 != null) goto L8;
    L12:
        r3 = r7.key;
        if (r3 != null) goto L15;
    L17:
        r3 = null;
    L18:
        if (r3 != null) goto L20;
        r3 = UIHelper.getString(2131891743);
    L20:
        r0.setName(r3);
        Long r6 = r7.size;
        if (r6 == null) goto L23;
        long r9 = r6.longValue();
    L24:
        r0.setSize(r9);
        String r10 = r7.mime;
        if (r10 == null) goto L28;
        r2 = r10;
    L28:
        r0.setMime(r2);
        r0.setFilePath(r7.path);
        File.Extra r11 = r7.extra;
        if (r11 == null) goto L33;
        File.Source r12 = r11.source;
        if (r12 == null) goto L33;
        a.getClass();
        r4 = e(r12);
    L33:
        r0.setSource(r4);
        if (r8 == null) goto L36;
        r5 = new ArrayList(r8);
    L36:
        r0.setRiskObjectKeys(r5);
        return r0;
    L23:
        r9 = 0;
        goto L24
    L15:
        if (Boolean.valueOf(!StringsKt.isBlank(r3)).booleanValue() == false) goto L17;
    L8:
        if (Boolean.valueOf(!StringsKt.isBlank(r3)).booleanValue() == true) goto L11;
        r3 = null;
    L11:
        if (r3 != null) goto L20;
        goto L12
    }

    public static /* synthetic */ void b(LinearLayout r17, List r18, String r19, Chat r20, int r21, boolean r22, Function1 r23, boolean r24, List r25, y6b.a r26, m2b.a r27, Message r28, int r29) {
        if ((r29 & 64) == 0) goto L5;
        Function1 r9 = null;
    L7:
        if ((r29 & 128) == 0) goto L9;
        boolean r10 = false;
    L11:
        if ((r29 & 256) == 0) goto L13;
        List r11 = null;
    L15:
        if ((r29 & 512) == 0) goto L17;
        y6b.a r12 = null;
    L19:
        if ((r29 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L21;
        m2b.a r13 = null;
    L23:
        if ((r29 & 2048) == 0) goto L25;
        Message r14 = null;
    L26:
        a(r17, r18, r19, r20, r21, r22, r9, r10, r11, r12, r13, r14, null, null);
        return;
    L25:
        r14 = r28;
        goto L26
    L21:
        r13 = r27;
        goto L23
    L17:
        r12 = r26;
        goto L19
    L13:
        r11 = r25;
        goto L15
    L9:
        r10 = r24;
        goto L11
    L5:
        r9 = r23;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v32, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r0v82 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.CharSequence, java.lang.String] */
    @JvmStatic
    public static final void a(LinearLayout r23, List<File> r24, String r25, Chat r26, int r27, boolean r28, Function1<? super View, Boolean> r29, boolean r30, List<String> r31, y6b.a<?> r32, m2b.a r33, Message r34, String r35, String r36) {
        LinearLayout r1 = r23;
        Chat r14 = r26;
        Intrinsics.checkNotNullParameter(r1, "container");
        a.getClass();
        List<File> r0 = r24;
        boolean r11 = true;
        boolean r10 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        View r8 = null;
        if (r2 == false) goto L23;
        if (r1 == null) goto L13;
        r23.removeAllViews();
    L13:
        if (r1 == null) goto L15;
        r1.setVisibility(8);
    L15:
        if (r1 == null) goto L17;
        ViewParent r3 = r23.getParent();
    L19:
        if ((r3 instanceof View) == false) goto L21;
        r8 = (View) r3;
    L21:
        if (r8 == null) goto L181;
        r8.setVisibility(8);
        return;
    L181:
        return;
    L17:
        r3 = null;
        goto L19
    L23:
        Object r4 = r23.getParent();
        if ((r4 instanceof View) == false) goto L26;
        View r5 = (View) r4;
    L27:
        if (r5 == null) goto L29;
        r5.setVisibility(0);
    L29:
        r1.setVisibility(0);
        r23.removeAllViews();
        LayoutInflater r7 = LayoutInflater.from(r23.getContext());
        if (r32 != null) goto L33;
        if (r34 != null) goto L33;
        a r6 = new a(false ? 1 : 0);
    L48:
        Iterator r16 = r24.iterator();
        int r9 = 0;
    L50:
        if (r16.hasNext() == false) goto L188;
        Object r12 = r16.next();
        int r17 = r9 + 1;
        if (r9 >= 0) goto L54;
        CollectionsKt.throwIndexOverflow();
    L54:
        File r13 = (File) r12;
        View r15 = r7.inflate(2131559283, r1, r10);
        d r18 = a;
        Intrinsics.checkNotNull(r15);
        r18.getClass();
        String r19 = r13.name;
        if (r19 == null) goto L59;
        boolean r20 = StringsKt.isBlank(r19) ^ r11;
        ?? r21 = r19;
        if (r20 == false) goto L59;
    L60:
        if (r21 != 0) goto L69;
        String r22 = r13.key;
        if (r22 == null) goto L66;
        boolean r110 = !StringsKt.isBlank(r22);
        ?? r37 = r22;
        if (r110 == false) goto L66;
    L67:
        if (r37 != 0) goto L70;
        r37 = UIHelper.getString(2131891743);
    L70:
        Boolean r38 = r13.is_folder;
        Boolean r111 = Boolean.TRUE;
        boolean r39 = Intrinsics.areEqual(r38, r111);
        String r210 = BuildConfig.FLAVOR;
        if (r39 == true) goto L81;
        if (r21 != 0) goto L74;
    L77:
        boolean r40 = true;
    L78:
        if (r40 == true) goto L81;
        String r41 = null;
    L84:
        ((ImageView) r15.findViewById(2131363342)).setImageResource(a0.c(r41, r37, Intrinsics.areEqual(r13.is_folder, r111)));
        ?? r42 = (TextView) r15.findViewById(2131363348);
        r42.setText(r37);
        Context r43 = r42.getContext();
        if (r6.a == true) goto L87;
    L90:
        boolean r44 = true;
    L91:
        if (r44 == false) goto L93;
        int r45 = 2131106620;
    L94:
        r42.setTextColor(UIUtils.getColor(r43, r45));
        TextView r46 = (TextView) r15.findViewById(2131363351);
        final ProgressBar r47 = (ProgressBar) r15.findViewById(2131363352);
        if (r6.a == true) goto L97;
    L100:
        boolean r48 = true;
    L101:
        if (r48 == false) goto L111;
        int r49 = b.a[r6.b.ordinal()];
        if (r49 != r11) goto L105;
        String r50 = UIHelper.getString(2131891419);
    L109:
        r46.setText(r50);
        r47.setVisibility(8);
    L149:
        String r51 = r13.key;
        if (r51 == null) goto L153;
        r210 = r51;
    L153:
        if (r28 == true) goto L168;
        if (r25 != null) goto L156;
    L159:
        boolean r52 = true;
    L160:
        if (r52 == true) goto L168;
        if (r210.length() <= 0) goto L164;
        boolean r53 = true;
    L165:
        if (r53 == false) goto L168;
        if (r14 == null) goto L168;
        boolean r54 = true;
    L169:
        r15.setClickable(r54);
        r15.setFocusable(r54);
        if (r29 == 0) goto L172;
        f r55 = new f(r29);
    L173:
        r15.setOnLongClickListener(r55);
        if (r54 == false) goto L176;
        int r112 = r9;
        View r113 = r15;
        int r56 = 8;
        r113.setOnClickListener(new g(r33, r15, r26, r27, r32, r34, r13, r25, r31, r35, r36));
        View r57 = null;
    L177:
        ViewGroup.LayoutParams r58 = r113.getLayoutParams();
        Intrinsics.checkNotNull(r58, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r59 = (LinearLayout.LayoutParams) r58;
        if (r112 == CollectionsKt.getLastIndex(r24)) goto L180;
        a.getClass();
        Resources r60 = r23.getResources();
        r59.bottomMargin = (int) ((r56 * WindowDisplayMetricsOverride.apply(r60, r60.getDisplayMetrics()).density) + 0.5f);
    L180:
        r1 = r23;
        r1.addView(r113, r59);
        r14 = r26;
        r8 = r57;
        r9 = r17;
        r6 = r6;
        r7 = r7;
        r10 = false;
        r11 = true;
        goto L50
    L176:
        r113 = r15;
        r112 = r9;
        r56 = 8;
        r57 = null;
        r113.setOnClickListener(null);
        goto L177
    L172:
        r55 = null;
        goto L173
    L164:
        r53 = false;
        goto L165
    L156:
        if (r25.length() == 0) goto L159;
        r52 = false;
    L168:
        r54 = false;
        goto L169
    L105:
        if (r49 == 2) goto L107;
        r50 = UIHelper.getString(2131891415);
        goto L109
    L107:
        r50 = UIHelper.getString(2131891244);
        goto L109
    L111:
        Long r61 = r13.size;
        if (r61 == null) goto L114;
        String r62 = FileUtils.h(r61.longValue());
    L115:
        if (r62 != null) goto L117;
        r62 = BuildConfig.FLAVOR;
    L117:
        r46.setText(r62);
        if (r30 == false) goto L120;
        r47.setVisibility(8);
        goto L149
    L120:
        if (r28 == false) goto L140;
        String r63 = r13.key;
        if (r63 != null) goto L125;
        String r64 = BuildConfig.FLAVOR;
    L126:
        String r65 = r13.path;
        if (r65 != null) goto L130;
        r65 = BuildConfig.FLAVOR;
    L130:
        if (r65.length() != 0) goto L132;
        boolean r66 = true;
    L133:
        if (r66 == true) goto L140;
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L136
        Object r68 = Result.constructor-impl(UUID.fromString(r64));     // Catch: Throwable -> L136
    L139:
        if (Result.isSuccess-impl(r68) == false) goto L140;
    L141:
        if (r64 != null) goto L144;
        r47.setVisibility(8);
        goto L149
    L144:
        Intrinsics.checkNotNull(r47);
        ChatAttachmentUploadProgressStore.a(r64);
        Integer r69 = 0;
        if (r69 == null) goto L147;
        r47.setProgress(r69.intValue());
        r47.setVisibility(0);
    L148:
        final Ref.BooleanRef r70 = new Ref.BooleanRef();
        r70.element = r11;
        r15.addOnAttachStateChangeListener(new e(r70, ChatAttachmentUploadProgressStore.c(r64, new MessageAttachmentListBinder$bindAttachmentStatus$dispose$1(r70, r47)), r15));
        goto L149
    L147:
        r47.setVisibility(8);
    L136:
        th = move-exception;
        Result.Companion r71 = Result.Companion;
        r68 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L139
    L132:
        r66 = false;
        goto L133
    L125:
        r64 = r63;
    L140:
        r64 = null;
        goto L141
    L114:
        r62 = null;
        goto L115
    L97:
        if (MessagePermissionUtil.g(r6.b) == true) goto L100;
        r48 = false;
        goto L101
    L93:
        r45 = 2131106622;
        goto L94
    L87:
        if (MessagePermissionUtil.g(r6.b) == true) goto L90;
        r44 = false;
        goto L91
    L74:
        if (r21.length() == 0) goto L77;
        r40 = false;
    L81:
        r41 = r13.mime;
        if (r41 != null) goto L84;
        r41 = BuildConfig.FLAVOR;
    L66:
        r37 = r8;
        goto L67
    L69:
        r37 = r21;
    L59:
        r21 = r8;
        goto L60
    L188:
        return;
    L33:
        if (r32 == null) goto L38;
        ValidateIMFileResult r72 = r32.N();
        if (r72 == null) goto L38;
        IMFileResult r73 = r72.getResultType();
        if (r73 == null) goto L38;
    L43:
        MessagePermissionUtil.ReceiveAuthorizationState r74 = MessagePermissionUtil.h(r73);
        if (r32 == null) goto L46;
        boolean r75 = MessagePermissionUtil.f(r32, r14, null);
    L47:
        r6 = new a(r75, r74);
        goto L48
    L46:
        r75 = MessagePermissionUtil.c(r34, r14, null);
    L38:
        if (r34 == null) goto L42;
        ValidateIMFileResult r76 = r34.getValidateIMFileResult();
        if (r76 == null) goto L42;
        r73 = r76.getResultType();
    L42:
        r73 = null;
        goto L43
    L26:
        r5 = null;
        goto L27
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }
}
