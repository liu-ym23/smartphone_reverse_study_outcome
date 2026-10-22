package com.larus.extension.summary_card.impl.cell;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ixigua.lib.track.TrackParams;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.helper.n0;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.utils.w2;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.extension.summary_card.api.SummaryCardConfigDelegate;
import com.larus.extension.summary_card.api.model.SummaryCardItemType;
import com.larus.extension.summary_card.api.model.SummaryCardMessageContent;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.r2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001L\u0018\u0000 _2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001_B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u001eH\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020*H\u0002JZ\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\n\u00101\u001a\u000602j\u0002`32\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020'2\f\u00107\u001a\b\u0012\u0004\u0012\u00020'082\u0006\u00109\u001a\u00020*2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0002J\b\u0010=\u001a\u00020!H\u0016J\b\u0010>\u001a\u00020!H\u0016J7\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u001e2\u0006\u0010E\u001a\u00020*H\u0002¢\u0006\u0002\u0010FJ\u0018\u0010G\u001a\u00020!2\u0006\u0010H\u001a\u00020C2\u0006\u0010I\u001a\u00020*H\u0002J\u001c\u0010J\u001a\u00020!2\b\u00106\u001a\u0004\u0018\u00010'2\b\u0010\"\u001a\u0004\u0018\u000105H\u0002J\u001c\u0010N\u001a\u00020!2\b\u00106\u001a\u0004\u0018\u00010'2\b\u00104\u001a\u0004\u0018\u000105H\u0002J\u001c\u0010Q\u001a\u00020!2\b\u00106\u001a\u0004\u0018\u00010'2\b\u00104\u001a\u0004\u0018\u000105H\u0002J\u0012\u0010R\u001a\u00020*2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J$\u0010S\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010T\u001a\u00020U2\b\u0010\"\u001a\u0004\u0018\u000105H\u0002J(\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u00020*2\u0006\u0010X\u001a\u00020*2\u0006\u0010Y\u001a\u00020*2\u0006\u0010Z\u001a\u00020[H\u0016J\u0012\u0010\\\u001a\u00020]2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\f\u0010^\u001a\u00020'*\u00020'H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0004\n\u0002\u0010MR\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/larus/extension/summary_card/impl/cell/SummaryCardCell;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/extension/summary_card/impl/cell/SummaryCardCellState;", "<init>", "()V", "box", "Lcom/larus/extension/summary_card/impl/cell/SummaryCardBox;", "lastClickCodeSpanCopyTs", "", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "summaryCardAbility", "Lcom/larus/extension/summary_card/impl/component/ISummaryCardAbility;", "getSummaryCardAbility", "()Lcom/larus/extension/summary_card/impl/component/ISummaryCardAbility;", "summaryCardAbility$delegate", "onCreateBoxView", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewType", "", "boxType", "onBindView", "", "view", "state", "position", "innerBind", "message", "Lcom/larus/im/bean/message/Message;", "scrollToRecyclerViewBottom", "isOnlyReadModel", "", "buildMenuPanel", "Lcom/larus/bmhome/view/screenmenu/CommonMenu;", "fragment", "Landroidx/fragment/app/Fragment;", "hostView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "Lcom/larus/bmhome/chat/list/base/MessageAdapter;", "markdownView", "Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "data", "currentActionMessageGetter", "Lkotlin/Function0;", "isMenuTimestampEnabled", "list", "", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "onViewDetachedFromWindow", "onViewAttachedToWindow", "onVideoSummaryExposure", "isAllShown", "isStoredDatabase", "fromItemId", "", "videoSummarySource", "isPlaceHolder", "(IILjava/lang/String;Ljava/lang/Integer;Z)V", "onVideoSummaryClick", "buttonType", "isExpand", "performClick", "clickRunnable", "com/larus/extension/summary_card/impl/cell/SummaryCardCell$clickRunnable$1", "Lcom/larus/extension/summary_card/impl/cell/SummaryCardCell$clickRunnable$1;", "performSingleClick", "markdownSelectHelper", "Lcom/larus/bmhome/chat/api/IMarkDownSelectHelper;", "performDoubleClick", "isRealVideoSummaryMsg", "performLongClick", "bot", "Lcom/larus/im/bean/bot/BotModel;", "onCellVisibilityChange", "isVisible", "isFullyVisible", "lastVisible", "showRatio", "", "getCardStatus", "Lcom/larus/extension/summary_card/impl/component/SummaryCardStatus;", "getCurrentActionMessage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SummaryCardCell extends BaseMessageListCell<z> {
    public static final /* synthetic */ int k = 0;
    public SummaryCardBox e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final b i;
    public final com.larus.bmhome.chat.api.z j;

    public static final class a {
    }

    public static final class b implements Runnable {
        public int a;
        public CustomMarkdownTextView b;
        public Message c;
        public final /* synthetic */ SummaryCardCell d;

        public final void a() {
            int r0 = this.a;
            if (r0 != 1) goto L13;
            SummaryCardCell r1 = this.d;
            Message r3 = this.c;
            int r4 = SummaryCardCell.k;
            r1.getClass();
            if (r3 == null) goto L33;
            IChatRepoService r2 = zh8.a.a;
            String r5 = r2.getReceiver().c().o6();
            if (Intrinsics.areEqual(r3.getMessageId(), r5) == false) goto L33;
            if ((SystemClock.elapsedRealtime() - 0) <= 100) goto L33;
            r2.getReceiver().c().i6("VideoSummaryCell", true);
        L33:
            this.a = 0;
            return;
        L13:
            if (r0 != 2) goto L33;
            SummaryCardCell r6 = this.d;
            Message r7 = this.c;
            AppCompatTextView r8 = this.b;
            int r9 = SummaryCardCell.k;
            r6.getClass();
            if (r8 == null) goto L33;
            if (r7 == null) goto L33;
            q0 r10 = lf8.a.b(r6);
            if (r10 == null) goto L33;
            com.larus.bmhome.chat.api.z r11 = r6.j;
            if (r11 == null) goto L33;
            if (o0.d(r7.getMessageId()) == true) goto L26;
        L31:
            boolean r12 = false;
        L32:
            com.larus.bmhome.chat.api.z.a.b(r11, r10, r8, r7, r12, "double_click_text", 0, false, null, 480);
            goto L33
        L26:
            if (m99.a.f(r7) != true) goto L28;
            boolean r13 = true;
        L29:
            if (r13 == false) goto L31;
            r12 = true;
            goto L32
        L28:
            r13 = false;
            goto L29
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(SummaryCardCell r1) {
            this.d = r1;
        }
    }

    static {
    }

    public final void onViewAttachedToWindow() {
        this.i.a = 0;
    }

    public final void onViewDetachedFromWindow() {
        b r0 = this.i;
        r0.a = 0;
        com.larus.bmhome.chat.layout.item.i r1 = this.e;
        if (r1 == null) goto L6;
        r1.removeCallbacks(r0);
        return;
    }

    public SummaryCardCell() {
        this.f = LazyKt.lazy(new w(this));
        this.g = LazyKt.lazy(new x(this));
        this.h = LazyKt.lazy(new y(this));
        this.i = new b(this);
        this.j = ILegacyChatUiServiceDelegate.b.F8();
    }

    public final Message o(Message r4) {
        if (com.larus.bmhome.chat.bean.d.x0(r4) == false) goto L14;
        n0 r0 = n0.a;
        String r1 = r4.getMessageId();
        r0.getClass();
        int r2 = w2.a(r1);
        List r3 = r4.getSubList();
        if (r3 == null) goto L10;
        if (r2 < 0) goto L10;
        if (r2 >= r3.size()) goto L10;
        Object r5 = ListProtector.get(r3, r2);
    L11:
        Message r6 = (Message) r5;
        if (r6 == null) goto L14;
        return r6;
    L10:
        r5 = null;
    L14:
        return r4;
    }

    /* JADX WARN: Type inference failed for: r14v1, types: [android.view.View, android.widget.LinearLayout, com.larus.bmhome.chat.layout.item.i, com.larus.extension.summary_card.impl.cell.SummaryCardBox] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void r(final Message r83) {
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.g.getValue();
        if (r0 == null) goto L6;
        BotModel r1 = r0.j0();
        if (r1 == null) goto L6;
    L7:
        final BotModel r5 = r1;
        de8.c r2 = (de8.c) this.f.getValue();
        if (r2 == null) goto L10;
        r2.m();
    L10:
        de8.c r3 = (de8.c) this.f.getValue();
        if (r3 == null) goto L13;
        boolean r8 = r3.C();
    L14:
        final ?? r14 = this.e;
        if (r14 == 0) goto L358;
        SummaryCardCell$innerBind$1 r9 = new SummaryCardCell$innerBind$1(this);
        SummaryCardCell$innerBind$2 r10 = new SummaryCardCell$innerBind$2(this);
        final SummaryCardCell$innerBind$3 r11 = new SummaryCardCell$innerBind$3(this);
        SummaryCardCell$innerBind$4 r12 = new SummaryCardCell$innerBind$4(this);
        com.larus.extension.summary_card.impl.component.a r15 = (com.larus.extension.summary_card.impl.component.a) this.h.getValue();
        Intrinsics.checkNotNullParameter(r83, "data");
        Intrinsics.checkNotNullParameter(r5, "bot");
        Intrinsics.checkNotNullParameter(r9, "onMarkdownViewLongClick");
        Intrinsics.checkNotNullParameter(r10, "onMarkdownViewClick");
        Intrinsics.checkNotNullParameter(r11, "onVideoSummaryClick");
        Intrinsics.checkNotNullParameter(r12, "scrollToRecyclerViewBottom");
        if (m99.a.f(r83) == false) goto L360;
        r14.C = r15;
        r14.B = null;
        if (r83.getContent() != null) goto L352;
    L51:
        SummaryCardMessageContent r4 = r14.B;
        if (r4 == null) goto L57;
        String r6 = r4.getItemCover();
        if (r6 == null) goto L57;
        String r7 = r6;
    L58:
        SummaryCardMessageContent r13 = r14.B;
        if (r13 == null) goto L64;
        String r16 = r13.getItemTitle();
        if (r16 == null) goto L64;
        String r17 = r16;
    L65:
        SummaryCardMessageContent r18 = r14.B;
        if (r18 == null) goto L71;
        String r19 = r18.getAuthorName();
        if (r19 == null) goto L71;
        String r20 = r19;
    L72:
        String r21 = r83.getMessageId();
        if (r21 != null) goto L75;
    L78:
        boolean r22 = true;
    L80:
        if (r22 == false) goto L88;
        Map r23 = r83.getBusinessExt();
        if (r23 == null) goto L84;
        String r24 = (String) r23.get("feed_is_place_holder");
    L86:
        if (Intrinsics.areEqual(r24, "1") == false) goto L88;
        boolean r25 = true;
    L89:
        SummaryCardMessageContent r26 = r14.B;
        if (r26 == null) goto L95;
        String r27 = r26.getContent();
        if (r27 == null) goto L95;
        String r28 = r27;
    L96:
        SummaryCardMessageContent r29 = r14.B;
        if (r29 == null) goto L102;
        Integer r30 = r29.getSource();
        if (r30 == null) goto L102;
        String r31 = r30.toString();
        if (r31 == null) goto L102;
    L103:
        String r210 = r31;
        com.larus.extension.summary_card.impl.component.g r32 = r14.q(r83);
        boolean r33 = r32.c;
        com.larus.extension.summary_card.impl.component.f r34 = r32.b;
        if ((r34 instanceof com.larus.extension.summary_card.impl.component.f.c) == false) goto L106;
    L109:
        boolean r35 = true;
    L110:
        if (r33 == false) goto L112;
        SummaryCardMessageContent r110 = null;
        boolean r211 = false;
    L113:
        r14.B = r110;
        if (r83.getContent() != null) goto L350;
        SummaryCardCell$innerBind$4 r212 = r12;
    L151:
        TextView r111 = r14.r;
        if (r111 != null) goto L154;
        SummaryCardCell$innerBind$2 r213 = r10;
    L187:
        TextView r36 = r14.r;
        if (r36 == null) goto L190;
        we8.a.b(r36, i5.q(), false, null, null, 12);
    L190:
        TextView r37 = r14.s;
        if (r37 != null) goto L193;
    L213:
        TextView r38 = r14.s;
        if (r38 == null) goto L217;
        we8.a.b(r38, i5.m(), false, null, null, 12);
    L217:
        if (r7.length() <= 0) goto L219;
        boolean r39 = true;
    L221:
        if (r39 == false) goto L237;
        SimpleDraweeView r40 = r14.q;
        if (r40 == null) goto L225;
        e1.x(r40);
    L225:
        String r41 = r14.A;
        if (r41 != null) goto L228;
    L229:
        SimpleDraweeView r42 = r14.q;
        if (r42 == null) goto L232;
        ImageLoaderKt.u(r42, r7, "douyin_avatar_video_cover_image");
    L232:
        r14.A = r7;
    L233:
        TextView r43 = r14.r;
        if (r43 == null) goto L236;
        r43.setMaxLines(1);
    L236:
        String r44 = null;
    L246:
        e1.d(r14.s, new com.larus.extension.summary_card.impl.cell.a(r14, r83, r5, r11));
        e1.d(r14.r, new f(r14, r83, r5, r11));
        e1.d(r14.q, new g(r14, r83, r5, r11));
        String r45 = r83.getMessageId();
        if (r45 != null) goto L249;
    L252:
        boolean r46 = true;
    L253:
        Map r47 = r83.getBusinessExt();
        if (r47 == null) goto L256;
        String r48 = (String) r47.get("force_real_message_ui_type");
    L258:
        if (Intrinsics.areEqual(r48, "1") == true) goto L275;
        if (r46 == true) goto L264;
        com.larus.extension.summary_card.impl.component.f r49 = r32.b;
        if ((r49 instanceof com.larus.extension.summary_card.impl.component.f.c) == false) goto L275;
        if (((com.larus.extension.summary_card.impl.component.f.c) r49).a == true) goto L275;
    L264:
        Drawable r50 = ContextCompat.getDrawable(r14.getContext(), 2131240741);
        if (r50 == null) goto L267;
        r14.setBackground(r50);
    L267:
        Drawable r51 = ContextCompat.getDrawable(r14.getContext(), v19.c.b(2130971613, r14.getContext(), 2131240737));
        if (r51 == null) goto L272;
        View r52 = r14.v;
        if (r52 == null) goto L272;
        r52.setBackground(r51);
    L272:
        TextView r53 = r14.y;
        if (r53 == null) goto L283;
        e1.t(r53, 0.0f, 2131100488);
    L283:
        if (r25 == true) goto L285;
        boolean r54 = false;
        if (SummaryCardConfigDelegate.b.a() == false) goto L323;
        r14.n(r35, r83, r5, r28, r210, r8, r9, r213, r11, r212);
    L340:
        if (r15 == null) goto L359;
        String r55 = r83.getLocalMessageId();
        if (r55 != null) goto L344;
        r55 = "";
    L344:
        r15.u80(r55, com.larus.extension.summary_card.impl.component.g.a(r14.q(r83), r83, null, r211, 0, r25, 58));
        return;
    L359:
        return;
    L323:
        if (r28.length() != 0) goto L325;
        r54 = true;
    L325:
        if (r54 == false) goto L332;
        View r56 = r14.t;
        if (r56 == null) goto L329;
        e1.o(r56);
    L329:
        ConstraintLayout r57 = r14.z;
        if (r57 == null) goto L340;
        e1.o(r57);
        goto L340
    L332:
        View r58 = r14.t;
        if (r58 == null) goto L335;
        e1.x(r58);
    L335:
        ConstraintLayout r59 = r14.z;
        if (r59 == null) goto L338;
        e1.x(r59);
    L338:
        r14.n(r35, r83, r5, r28, r210, r8, r9, r213, r11, r212);
        goto L340
    L285:
        if (SummaryCardConfigDelegate.b.a() == true) goto L292;
        View r60 = r14.t;
        if (r60 == null) goto L289;
        e1.o(r60);
    L289:
        ConstraintLayout r61 = r14.z;
        if (r61 == null) goto L340;
        e1.o(r61);
        goto L340
    L292:
        View r62 = r14.t;
        if (r62 == null) goto L295;
        e1.x(r62);
    L295:
        ConstraintLayout r63 = r14.z;
        if (r63 == null) goto L298;
        e1.x(r63);
    L298:
        TextView r64 = new TextView(r14.getContext());
        r14.m(r64);
        r64.setLineSpacing(0.0f, 1.1f);
        SummaryCardMessageContent r65 = r14.B;
        if (r65 == null) goto L303;
        String r66 = r65.getContent();
        if (r66 == null) goto L303;
    L304:
        r64.setText(r66);
        r64.measure(View.MeasureSpec.makeMeasureSpec(r14.getMaxWidth(), Integer.MIN_VALUE), 0);
        int r67 = r64.getMeasuredHeight();
        View r68 = r14.x;
        if (r68 == null) goto L311;
        ViewGroup.LayoutParams r69 = r68.getLayoutParams();
        if (r69 == null) goto L310;
        r69.height = r67;
        r68.setLayoutParams(r69);
        goto L311
    L310:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L311:
        View r70 = r14.x;
        if (r70 == null) goto L314;
        e1.x(r70);
    L314:
        AppCompatTextView r71 = r14.w;
        if (r71 == null) goto L317;
        e1.o(r71);
    L317:
        TextView r72 = r14.y;
        if (r72 == null) goto L340;
        e1.o(r72);
    L303:
        r66 = " ";
    L275:
        r14.setBackground(e1.j(r14, c7.c(Float.valueOf(16.0f)), 2131100492));
        Drawable r73 = ContextCompat.getDrawable(r14.getContext(), v19.c.b(2130971612, r14.getContext(), 2131240734));
        if (r73 == null) goto L280;
        View r74 = r14.v;
        if (r74 == null) goto L280;
        r74.setBackground(r73);
    L280:
        TextView r75 = r14.y;
        if (r75 == null) goto L283;
        e1.t(r75, 0.0f, 2131100492);
        goto L283
    L256:
        r48 = r44;
        goto L258
    L249:
        if (r45.length() == 0) goto L252;
        r46 = false;
        goto L253
    L228:
        if (Intrinsics.areEqual(r41, r7) == true) goto L233;
    L237:
        SimpleDraweeView r76 = r14.q;
        if (r76 == null) goto L240;
        e1.o(r76);
    L240:
        SimpleDraweeView r77 = r14.q;
        r44 = null;
        if (r77 == null) goto L243;
        ImageLoaderKt.u(r77, null, "douyin_avatar_video_cover_image");
    L243:
        TextView r78 = r14.r;
        if (r78 == null) goto L246;
        r78.setMaxLines(2);
        goto L246
    L219:
        r39 = false;
        goto L221
    L193:
        if (r20.length() <= 0) goto L195;
        boolean r79 = true;
    L196:
        if (r79 == true) goto L346;
    L211:
        String r112 = "";
    L212:
        r37.setText(r112);
        goto L213
    L346:
        Result.Companion r80 = Result.Companion;     // Catch: Throwable -> L204
        StringCompanionObject r81 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L204
        Context r82 = r14.getContext();     // Catch: Throwable -> L204
        if (r82 == null) goto L201;
        String r84 = r82.getString(2131901252);     // Catch: Throwable -> L204
        if (r84 == null) goto L201;
    L202:
        Object r85 = Result.constructor-impl(String.format(r84, Arrays.copyOf(new Object[]{"@".concat(r20)}, 1)));     // Catch: Throwable -> L204
    L206:
        Object r113 = r85;
        if (Result.isFailure-impl(r113) == false) goto L209;
        r113 = null;
    L209:
        r112 = (String) r113;
        if (r112 != null) goto L212;
    L201:
        r84 = "";
    L204:
        th = move-exception;
        Result.Companion r86 = Result.Companion;
        r85 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L206
    L195:
        r79 = false;
        goto L196
    L154:
        if (r17.length() <= 0) goto L156;
        boolean r87 = true;
    L157:
        if (r87 == false) goto L160;
        r213 = r10;
    L185:
        r111.setText(r17);
        goto L187
    L160:
        if (r20.length() <= 0) goto L162;
        boolean r88 = true;
    L163:
        if (r88 == true) goto L356;
        r213 = r10;
    L184:
        r17 = "";
        goto L185
    L356:
        Result.Companion r89 = Result.Companion;     // Catch: Throwable -> L174
        StringCompanionObject r90 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L174
        Context r91 = r14.getContext();     // Catch: Throwable -> L174
        if (r91 == null) goto L168;
        String r92 = r91.getString(2131901252);     // Catch: Throwable -> L174
        if (r92 == null) goto L168;
    L169:
        r213 = r10;
        Object r93 = Result.constructor-impl(String.format(r92, Arrays.copyOf(new Object[]{"@".concat(r20)}, 1)));     // Catch: Throwable -> L172
    L178:
        if (Result.isFailure-impl(r93) == false) goto L180;
        r93 = null;
    L180:
        r17 = (String) r93;
        if (r17 != null) goto L185;
    L172:
        th = th;
    L176:
        Result.Companion r94 = Result.Companion;
        r93 = Result.constructor-impl(ResultKt.createFailure(th));
    L168:
        r92 = "";
    L174:
        th = th;
        r213 = r10;
        goto L176
    L162:
        r88 = false;
        goto L163
    L156:
        r87 = false;
        goto L157
    L350:
        Result.Companion r95 = Result.Companion;     // Catch: Throwable -> L121
        r212 = r12;
        Object r96 = Result.constructor-impl((SummaryCardMessageContent) HttpExtKt.f.fromJson(r83.getContent(), SummaryCardMessageContent.class));     // Catch: Throwable -> L119
    L124:
        Object r114 = r96;
        if (Result.isFailure-impl(r114) == false) goto L127;
        r114 = null;
    L127:
        SummaryCardMessageContent r115 = (SummaryCardMessageContent) r114;
        r14.B = r115;
        if (r115 == null) goto L130;
        Integer r116 = r115.getItemType();
    L131:
        int r97 = SummaryCardItemType.VIDEO.getValue();
        if (r116 != null) goto L135;
    L146:
        SummaryCardItemType.ARTICLE.getValue();
        if (r116 == null) goto L151;
        r116.intValue();
        goto L151
    L135:
        if (r116.intValue() != r97) goto L146;
        if (MainBotServiceDelegate.b.b() == false) goto L139;
        r14.t();
        goto L151
    L139:
        SummaryCardMessageContent r98 = r14.B;
        if (r98 == null) goto L151;
        String r99 = r98.getItemId();
        if (r99 == null) goto L151;
        r2 r117 = r14.D;
        if (r117 == null) goto L151;
        r14.getContext();
        r117.c(CollectionsKt.listOf(r99));
        goto L151
    L130:
        r116 = null;
    L119:
        th = th;
    L123:
        Result.Companion r118 = Result.Companion;
        r96 = Result.constructor-impl(ResultKt.createFailure(th));
    L121:
        th = th;
        r212 = r12;
        goto L123
    L112:
        r211 = r33;
        r110 = null;
        goto L113
    L106:
        if ((r34 instanceof com.larus.extension.summary_card.impl.component.f.b) == true) goto L109;
        r35 = false;
    L102:
        r31 = TriggerSendLoading.NO_LOADING;
    L95:
        r28 = "";
        goto L96
    L84:
        r24 = null;
    L88:
        r25 = false;
        goto L89
    L75:
        if (r21.length() == 0) goto L78;
        r22 = false;
    L71:
        r20 = "";
    L64:
        r17 = "";
    L57:
        r7 = "";
        goto L58
    L352:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L23
        Object r101 = Result.constructor-impl((SummaryCardMessageContent) HttpExtKt.f.fromJson(r83.getContent(), SummaryCardMessageContent.class));     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r101) == false) goto L28;
        r101 = null;
    L28:
        SummaryCardMessageContent r102 = (SummaryCardMessageContent) r101;
        r14.B = r102;
        if (r102 == null) goto L31;
        Integer r103 = r102.getItemType();
    L32:
        int r104 = SummaryCardItemType.VIDEO.getValue();
        if (r103 != null) goto L36;
    L47:
        SummaryCardItemType.ARTICLE.getValue();
        if (r103 == null) goto L51;
        r103.intValue();
        goto L51
    L36:
        if (r103.intValue() != r104) goto L47;
        if (MainBotServiceDelegate.b.b() == false) goto L40;
        r14.t();
        goto L51
    L40:
        SummaryCardMessageContent r105 = r14.B;
        if (r105 == null) goto L51;
        String r106 = r105.getItemId();
        if (r106 == null) goto L51;
        r2 r107 = r14.D;
        if (r107 == null) goto L51;
        r14.getContext();
        r107.c(CollectionsKt.listOf(r106));
        goto L51
    L31:
        r103 = null;
    L23:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r101 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L360:
        return;
    L358:
        return;
    L13:
        r8 = false;
    L6:
        r1 = new BotModel("unknown", null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L7
    }

    public final void k(boolean r12, boolean r13, boolean r14) {
        z r15 = (z) ((BaseMessageListCell) this).d;
        if (r15 == null) goto L93;
        Message r16 = r15.e;
        if (r16 == null) goto L100;
        if (r12 == false) goto L94;
        String r17 = r16.getMessageId();
        boolean r18 = true;
        if (r17 != null) goto L11;
    L14:
        boolean r19 = true;
    L15:
        Integer r1 = null;
        if (r19 == false) goto L24;
        Map r110 = r16.getBusinessExt();
        if (r110 == null) goto L20;
        String r111 = (String) r110.get("feed_is_place_holder");
    L22:
        if (Intrinsics.areEqual(r111, "1") == false) goto L24;
        boolean r112 = true;
    L25:
        z r2 = (z) ((BaseMessageListCell) this).d;
        if (r2 == null) goto L28;
        Message r3 = r2.e;
    L29:
        if (r3 == null) goto L35;
        com.larus.extension.summary_card.impl.component.a r4 = (com.larus.extension.summary_card.impl.component.a) this.h.getValue();
        if (r4 == null) goto L33;
        com.larus.extension.summary_card.impl.component.g r5 = r4.TY(r3);
    L34:
        if (r5 == null) goto L35;
    L36:
        com.larus.extension.summary_card.impl.component.g r6 = r5;
        boolean r7 = Intrinsics.areEqual(r6.b, com.larus.extension.summary_card.impl.component.f.b.a);
        String r8 = "";
        if (r112 == false) goto L56;
        if (r6.e == false) goto L95;
        SummaryCardBox r113 = this.e;
        if (r113 == null) goto L44;
        String r114 = r113.getItemId();
        if (r114 == null) goto L44;
    L47:
        String r9 = r114;
    L48:
        s(r7 ? 1 : 0, 0, r9, null, true);
        com.larus.extension.summary_card.impl.component.a r115 = (com.larus.extension.summary_card.impl.component.a) this.h.getValue();
        if (r115 == null) goto L96;
        String r116 = r16.getLocalMessageId();
        if (r116 == null) goto L54;
        r8 = r116;
    L54:
        r115.u80(r8, com.larus.extension.summary_card.impl.component.g.a(r6, null, null, false, 0, false, 111));
        return;
    L96:
        return;
    L44:
        r114 = m99.a.b(r16);
        if (r114 != null) goto L47;
        r9 = "";
        goto L48
    L95:
        return;
    L56:
        if (r6.d == false) goto L98;
        String r117 = m99.a.c(r16);
        if (r117 == null) goto L60;
        r1 = StringsKt.toIntOrNull(r117);
    L60:
        Integer r10 = r1;
        com.larus.extension.summary_card.impl.component.f r118 = r6.b;
        if ((r118 instanceof com.larus.extension.summary_card.impl.component.f.c) == false) goto L63;
    L66:
        boolean r119 = true;
    L67:
        SummaryCardBox r11 = this.e;
        if (r11 == null) goto L71;
        String r20 = r11.getItemId();
        if (r20 == null) goto L71;
    L74:
        String r21 = r20;
    L75:
        String r22 = r16.getMessageId();
        if (r22 != null) goto L78;
    L81:
        if (r18 == false) goto L84;
        if (r119 == true) goto L84;
        s(r7 ? 1 : 0, 0, r21, r10, false);
    L85:
        com.larus.extension.summary_card.impl.component.a r120 = (com.larus.extension.summary_card.impl.component.a) this.h.getValue();
        if (r120 == null) goto L99;
        String r121 = r16.getLocalMessageId();
        if (r121 == null) goto L91;
        r8 = r121;
    L91:
        r120.u80(r8, com.larus.extension.summary_card.impl.component.g.a(r6, null, null, false, 0, false, 119));
        return;
    L99:
        return;
    L84:
        s(r7 ? 1 : 0, 1, r21, r10, false);
        goto L85
    L78:
        if (r22.length() == 0) goto L81;
        r18 = false;
    L71:
        r20 = m99.a.b(r16);
        if (r20 != null) goto L74;
        r21 = "";
        goto L75
    L63:
        if ((r118 instanceof com.larus.extension.summary_card.impl.component.f.b) == true) goto L66;
        r119 = false;
        goto L67
    L98:
        return;
    L33:
        r5 = null;
    L35:
        int r23 = com.larus.extension.summary_card.impl.component.g.h;
        r5 = com.larus.extension.summary_card.impl.component.g.a.a(r3);
        goto L36
    L28:
        r3 = null;
        goto L29
    L20:
        r111 = null;
    L24:
        r112 = false;
        goto L25
    L11:
        if (r17.length() == 0) goto L14;
        r19 = false;
        goto L15
    L94:
        return;
    L100:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View, com.larus.extension.summary_card.impl.cell.SummaryCardBox] */
    public final View m(Context r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        ?? r4 = new SummaryCardBox(r1);
        this.e = r4;
        return r4;
    }

    public final void onBindView(View r1, ei9.f r2, int r3) {
        z r4 = (z) r2;
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r4, "state");
        r(r4.e);
    }

    public final void s(int r8, int r9, String r10, Integer r11, boolean r12) {
        de8.c r0 = (de8.c) this.f.getValue();
        if (r0 == null) goto L7;
        long r3 = r0.l();
        if (r3 <= 0) goto L7;
        long r5 = SystemClock.elapsedRealtime() - r3;
    L8:
        JSONObject r1 = new JSONObject();
        if (r11 != null) goto L26;
        int r13 = 0;
    L13:
        r1.put("model_source", r13);     // Catch: JSONException -> L17
        r1.put("is_all_shown", r8);     // Catch: JSONException -> L17
        r1.put("is_stored_in_database", r9);     // Catch: JSONException -> L17
        r1.put("from_item_id", r10);     // Catch: JSONException -> L17
        r1.put("is_placeholder", r12 ? 1 : 0);     // Catch: JSONException -> L17
        if (r5 <= 0) goto L19;
        r1.put("timeuse", r5);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        FLogger.a.e("SummaryCardCell", "onVideoSummaryExposure error in  " + e.getLocalizedMessage());
    L19:
        TrackParams r14 = new TrackParams().merge(r1);
        by7.a r15 = new by7.a("flow_show_video_summary_card");
        if (lf8.a.d(this) != null) goto L22;
    L24:
        r15.a.merge(r14);
        r15.b();
        return;
    L22:
        if ((lf8.a.d(this) instanceof by7.e) == false) goto L24;
        by7.e r16 = lf8.a.d(this);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.ixigua.lib.track.ITrackNode");
        r15.b = r16;
        goto L24
    L26:
        r13 = r11.intValue();     // Catch: JSONException -> L17
    L7:
        r5 = -1;
        goto L8
    }
}
