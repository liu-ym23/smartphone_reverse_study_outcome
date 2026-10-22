package com.ss.android.lark.integrator.im.impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.lark.lark_biz_feed_android.n;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.FeedCard;
import com.bytedance.lark.pb.basic.v1.Message;
import com.bytedance.lark.pb.feed.v1.ChatData;
import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import com.bytedance.lark.pb.feed.v1.ThreadData;
import com.larus.office.base.s;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.app.entity.EmojiProperty;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.app.entity.MutexMarkType;
import com.ss.android.lark.feed.app.entity.TextProperty;
import com.ss.android.lark.feed.app.entity.TextWithEmojiProperty;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.cardcomponent.preview.FeedDigestTextView;
import com.ss.android.lark.feed.export.feedlist.BaseFeedFragment;
import com.ss.android.lark.feed.shared.page.FeedItemsFragment;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.creategroup.page.FlowGroupCreateActivity;
import com.ss.android.lark.flow.feed.page.FlowHumanFeedItemsFragment;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.integrator.im.extension.ExtensionManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKUserScope
public final class IIMUserServiceImpl extends c0c.c implements aza.d {
    public static final /* synthetic */ int o = 0;
    public final com.bytedance.lark.lark_biz_feed_android_wrapper.b b;
    public final com.ss.android.lark.flow.feed.data.a c;

    @Inject
    public com.ss.android.lark.chatwindow.launcher.c d;

    @Inject
    public aza.b e;

    @Inject
    public kza.h f;

    @Inject
    public bza.a g;

    @Inject
    public cza.a h;

    @Inject
    public nza.b i;

    @Inject
    public dza.b j;

    @Inject
    public fza.a k;
    public final Lazy l;
    public final CoroutineScope m;
    public final AtomicReference<pza.a> n;

    public static final class a {
    }

    static {
    }

    public final aza.b E4() {
        aza.b r0 = this.e;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("humansChatSettingsServiceInternal");
        return null;
    L7:
        return r0;
    }

    public final fza.a J4() {
        fza.a r0 = this.k;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("officeFeedService");
        return null;
    L7:
        return r0;
    }

    public final dza.b P() {
        dza.b r0 = this.j;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("officeChatService");
        return null;
    L7:
        return r0;
    }

    public final FlowHumanFeedItemsFragment Q8() {
        FlowHumanFeedItemsFragment r0 = new FlowHumanFeedItemsFragment();
        Bundle r1 = r0.getArguments();
        if (r1 != null) goto L5;
        r1 = new Bundle();
    L5:
        r1.putLong("lark.feed.app.refactor.FEED_FILTER", FeedFolderCompat.INSTANCE.getMESSAGE().getId());
        PassportcConvention.f(r1, LarkContext.getApplication());
        r0.setArguments(r1);
        ((FeedItemsFragment) r0).n = new f();
        ((BaseFeedFragment) r0).d = new g();
        return r0;
    }

    public final kza.h X9() {
        kza.h r0 = this.f;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("galleryImageService");
        return null;
    L7:
        return r0;
    }

    public final nza.b Z1() {
        nza.b r0 = this.i;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("officeMessageMenuService");
        return null;
    L7:
        return r0;
    }

    public final bza.a ab() {
        bza.a r0 = this.g;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("auditService");
        return null;
    L7:
        return r0;
    }

    public final cza.a getAvatarService() {
        cza.a r0 = this.h;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("officeAvatarService");
        return null;
    L7:
        return r0;
    }

    public final void W7() {
        d r0 = d.a;
    }

    public static String m(n r3) {
        StringBuilder r0 = new StringBuilder("LarkFeedInfo(badgeCount=");
        r0.append(r3.a);
        r0.append(", rankTimeMs=");
        r0.append(r3.c);
        r0.append(", feedId=");
        FeedEntityPreview r1 = r3.b;
        FeedCard.FeedType r2 = null;
        if (r1 == null) goto L5;
        String r4 = r1.feed_id;
    L6:
        r0.append(r4);
        r0.append(", feedType=");
        FeedEntityPreview r5 = r3.b;
        if (r5 == null) goto L9;
        r2 = r5.feed_type;
    L9:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L5:
        r4 = null;
        goto L6
    }

    public final void G9(uh9.b.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Log.i("IIMUserServiceImpl", "unregisterMigrateStatusListener, listener=" + r3);
        this.c.c(r3);
    }

    public final void J5(hza.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((CopyOnWriteArrayList) this.l.getValue()).contains(r2) == true) goto L6;
        ((CopyOnWriteArrayList) this.l.getValue()).add(r2);
        return;
    }

    public final void R6(hza.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((CopyOnWriteArrayList) this.l.getValue()).remove(r2);
    }

    public final void d(f0c.h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r3, "state");
        CoroutineScopeKt.cancel$default(this.m, null, 1, null);
    }

    public final void i(f0c.h r8) {
        Intrinsics.checkNotNullParameter(r8, "state");
        Intrinsics.checkNotNullParameter(r8, "state");
        BuildersKt.launch$default(this.m, null, null, new IIMUserServiceImpl$onPrepared$1(this, null), 3, null);
    }

    public final Object ma(Continuation<? super Result<pza.a>> r5) {
        if ((r5 instanceof IIMUserServiceImpl$getHumanFeedDisplayItem$1) == false) goto L7;
        IIMUserServiceImpl$getHumanFeedDisplayItem$1 r0 = (IIMUserServiceImpl$getHumanFeedDisplayItem$1) r5;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
        Object r7 = ((Result) r6).unbox-impl();
    L18:
        if (Result.isSuccess-impl(r7) == false) goto L20;
        Log.i("IIMUserServiceImpl", "IIMUserServiceImpl getHumanFeedDisplayItem success: " + m((n) r7));
    L20:
        Throwable r4 = Result.exceptionOrNull-impl(r7);
        if (r4 == null) goto L24;
        Log.e("IIMUserServiceImpl", "IIMUserServiceImpl getHumanFeedDisplayItem failure: " + r4.getMessage());
    L24:
        if (Result.isSuccess-impl(r7) == false) goto L27;
        r7 = n((n) r7);
    L27:
        return Result.constructor-impl(r7);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        com.bytedance.lark.lark_biz_feed_android_wrapper.b r8 = this.b;
        IIMUserServiceImpl$getHumanFeedDisplayItem$2 r9 = IIMUserServiceImpl$getHumanFeedDisplayItem$2.INSTANCE;
        r0.label = 1;
        r7 = r8.lc(r9, r0);
        if (r7 != r2) goto L18;
        return r2;
    L7:
        r0 = new IIMUserServiceImpl$getHumanFeedDisplayItem$1(this, r5);
        goto L8
    }

    public final pza.a n(n r20) {
        pza.a r2 = this.n.get();
        if (r2 != null) goto L5;
    L7:
        long r9 = r20.c;
        FeedEntityPreview r3 = r20.b;
        if (r3 != null) goto L10;
        String r15 = "";
    L63:
        int r11 = RangesKt.coerceAtMost(r20.a, 99);
        int r12 = r20.e;
        int r13 = r20.g;
        pza.a r1 = new pza.a(r9, r11, r12, r13, r12 - r13, r15, r20.d);
        AtomicReference<pza.a> r4 = this.n;
    L65:
        if (r4.compareAndSet(r2, r1) == true) goto L70;
        if (r4.get() == r2) goto L65;
    L70:
        return r1;
    L10:
        UIFeedCard r5 = new com.ss.android.lark.feed.molten.page.c().a(com.ss.android.lark.feed.shared.data.utils.h.a(r3));
        boolean r6 = true;
        List r8 = null;
        if (r5 != null) goto L13;
    L17:
        int r7 = ffb.a.a;
        Application r10 = LarkContext.getApplication();
        Intrinsics.checkNotNullParameter(r10, "context");
        SpannableStringBuilder r16 = new SpannableStringBuilder();
        List r14 = r8;
        if (r14 != null) goto L20;
    L23:
        if (r6 == false) goto L26;
        r16.append("");
    L25:
        SpannableStringBuilder r17 = r16;
        if (r17.length() <= 150) goto L48;
        CharSequence r18 = r17.subSequence(0, 150);
        Intrinsics.checkNotNull(r18);
    L49:
        ThreadData r19 = r3.thread_data;
        if (r19 == null) goto L52;
        String r21 = r19.name + 183 + r18;
    L62:
        r15 = r21;
        goto L63
    L52:
        ChatData r22 = r3.chat_data;
        if (r22 != null) goto L55;
        r21 = r18.toString();
        Log.e("IIMUserServiceImpl", "thread_data and chat_data is null, previewDisplay size: " + r21.length());
        goto L62
    L55:
        if (r22.chat_type == Chat.Type.P2P) goto L57;
    L59:
        String r23 = "·";
    L60:
        r21 = r22.name + r23 + r18;
        goto L62
    L57:
        if (r22.last_message_type == Message.Type.DOUBAO) goto L59;
        r23 = ":";
        goto L60
    L48:
        r18 = r17;
        goto L49
    L26:
        Iterator r24 = r8.iterator();
        int r25 = 0;
    L28:
        if (r24.hasNext() == false) goto L25;
        TextProperty r26 = (DigestElement) r24.next();
        if ((r26 instanceof TextProperty) == false) goto L33;
        r16.append(r26.getContent());
        r16 = r16;
    L42:
        r16 = r16;
        goto L28
    L33:
        if ((r26 instanceof EmojiProperty) == false) goto L39;
        EmojiProperty r27 = (EmojiProperty) r26;
        String r110 = r27.component1();
        String r111 = r27.component2();
        if (r25 > 100) goto L38;
        int r112 = sdb.a.a;
        Intrinsics.checkNotNullParameter(r110, "emojiKey");
        sdb.a.a(r10, r16, r110, r111, null, sdb.a.a);
    L38:
        r25 = r25 + 1;
        goto L42
    L39:
        r16 = r16;
        if ((r26 instanceof TextWithEmojiProperty) == false) goto L44;
        r16.append(((TextWithEmojiProperty) r26).component1());
        EmojiHandler.a(UIHelper.getContext(), r16, ffb.a.a, 2, FeedDigestTextView.e, 0, -1);
        goto L42
    L44:
        throw new NoWhenBranchMatchedException();
    L20:
        if (r14.isEmpty() == true) goto L23;
        r6 = false;
        goto L23
    L13:
        if (r5.getMutexMarkType() != MutexMarkType.DRAFT) goto L15;
        boolean r113 = true;
    L16:
        r8 = r5.getDigestMessage(r113, null);
        goto L17
    L15:
        r113 = false;
        goto L16
    L5:
        if (r2.g <= r20.d) goto L7;
        return r2;
    }

    public final void q4(s r6) {
        Intrinsics.checkNotNullParameter(r6, "imExtension");
        List<qxa.b> r0 = ExtensionManager.a;
        Intrinsics.checkNotNullParameter(r6, "extension");
        ArrayList r1 = (ArrayList) ExtensionManager.b;
        if (r1.contains(r6) == true) goto L14;
        ArrayList r2 = (ArrayList) ExtensionManager.a;
        if (r2.contains(r6) == true) goto L15;
        StringBuilder r3 = new StringBuilder("addExtraExtension, context has init: ");
        AtomicBoolean r4 = ExtensionManager.d;
        r3.append(r4.get());
        Log.i("ExtensionManager", r3.toString());
        if (r4.get() == false) goto L11;
        Log.i("ExtensionManager", "addExtraExtension, install");
        r6.a(ExtensionManager.a());
        r1.add(r6);
        return;
    L11:
        Log.i("ExtensionManager", "addExtraExtension, add to manual");
        r2.add(r6);
        return;
    L15:
        return;
    }

    public final void s8(uh9.b.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Log.i("IIMUserServiceImpl", "registerMigrateStatusListener, listener=" + r3);
        this.c.a(r3);
    }

    public final void E7(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "targetId");
        Log.i("IIMUserServiceImpl", "enterProfileForNotification with targetId: " + r11);
        ((IProfileLauncherV2) ClaymoreServiceLoader.loadFirst(IProfileLauncherV2.class)).openUserProfileV2(LarkContext.getApplication(), null, r11, null, Chatter.Type.DOUBAO, null, new ContactSource(new ContactSource.a()), -1);
    }

    public final void g9(FragmentActivity r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        int r1 = dgb.a.d;
        dgb.a.C0248a.a().getClass();
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intent r0 = new Intent(r5, FlowGroupCreateActivity.class);
        PassportcConvention.e(r0, LarkContext.getApplication());
        Bundle r2 = new Bundle();
        r2.putString("key_group_create_scene", "group_create_scene_feed_create");
        r2.putBoolean("key_group_create_need_badge", r6);
        r0.putExtras(r2);
        r5.startActivity(r0);
        Log.d("FlowCreateGroupChatModule", "createGroup");
    }

    @Inject
    public IIMUserServiceImpl(com.bytedance.lark.lark_biz_feed_android_wrapper.b r2, com.ss.android.lark.flow.feed.data.a r3, m r4) {
        Intrinsics.checkNotNullParameter(r2, "badgeService");
        Intrinsics.checkNotNullParameter(r3, "doubaoFeedMigrateStatus");
        Intrinsics.checkNotNullParameter(r4, "passport");
        super(r4);
        this.b = r2;
        this.c = r3;
        this.l = LazyKt.lazy(IIMUserServiceImpl$humanFeedsChangedListeners$2.INSTANCE);
        this.m = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null));
        this.n = new AtomicReference();
        com.ss.android.lark.passportc.api.s.a(this);
    }

    public static void r(Context r1, String r2, Integer r3, boolean r4) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        Log.e("IIMUserServiceImpl", "openThreadForNotification: threadId is null");
        return;
    L11:
        l1.a r5 = new l1.a();
        r5.e = r2;
        if (r3 == null) goto L16;
        int r6 = r3.intValue();
        if (r6 < 0) goto L16;
        r5.f = r6;
    L16:
        r5.w = Boolean.valueOf(r4);
        int r7 = FlowChatModule.d;
        FlowChatModule r8 = FlowChatModule.a.a();
        l1 r9 = new l1(r5);
        r8.getClass();
        FlowChatModule.g(r1, r9);
        return;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void p(Context r1, String r2, String r3, Integer r4, boolean r5) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        Log.e("IIMUserServiceImpl", "openChatForNotification: chatId is null");
        return;
    L11:
        ChatBundle.a r6 = new ChatBundle.a();
        r6.a = r2;
        if (r3 == null) goto L14;
        r6.g = r3;
    L14:
        if (r4 == null) goto L18;
        int r7 = r4.intValue();
        if (r7 < 0) goto L18;
        r6.c = r7;
    L18:
        r6.b(Boolean.valueOf(r5));
        r6.d = "push";
        int r8 = FlowChatModule.d;
        FlowChatModule.a.a().d(r1, null, new ChatBundle(r6), null);
        return;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void p7(final Context r13, final String r14, final String r15, final String r16, final Integer r17, final Integer r18, final boolean r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Log.i("IIMUserServiceImpl", "enterChatOrThread with chat_id: " + r14 + ", thread_id: " + r15 + ", messageId: " + r16 + ", position: " + r17 + ", msgThreadPosition: " + r18 + ", useBottomSheet: " + r19 + ", anchorToMessage: " + r20);
        boolean r2 = false;
        if (r20 == false) goto L46;
        if (r16 != null) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == true) goto L46;
        if (r15 != null) goto L13;
    L18:
        boolean r1 = false;
    L19:
        if (r1 == false) goto L24;
        if (r18 != null) goto L22;
    L28:
        boolean r3 = false;
    L29:
        if (r3 == false) goto L44;
        if (r14 != null) goto L32;
    L35:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L46;
        if (r15 != null) goto L39;
    L42:
        boolean r5 = true;
    L43:
        if (r5 == false) goto L46;
    L39:
        if (r15.length() == 0) goto L42;
        r5 = false;
        goto L43
    L32:
        if (r14.length() == 0) goto L35;
        r4 = false;
    L44:
        ImSdkService.f().Fe(CollectionsKt.listOf(r16), new IIMUserServiceImpl$fetchMessageAndJump$1(r16, this, r13, r14, r17, r19, r18, r15));
        return;
    L22:
        if (r18.intValue() < 0) goto L28;
    L27:
        r3 = true;
        goto L29
    L24:
        if (r17 == null) goto L28;
        if (r17.intValue() < 0) goto L28;
    L13:
        if (r15.length() <= 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 != true) goto L18;
        r1 = true;
        goto L19
    L15:
        r6 = false;
        goto L16
    L6:
        if (r16.length() == 0) goto L9;
        r0 = false;
    L46:
        if (r14 != null) goto L48;
    L53:
        boolean r7 = false;
    L54:
        if (r7 == false) goto L63;
        if (r15 != null) goto L57;
    L60:
        boolean r8 = true;
    L61:
        if (r8 == false) goto L63;
        p(r13, r14, r16, r17, r19);
        return;
    L57:
        if (r15.length() == 0) goto L60;
        r8 = false;
    L63:
        if (r15 != null) goto L65;
    L70:
        if (r2 == false) goto L72;
        r(r13, r15, r18, r19);
        return;
    L72:
        Log.e("IIMUserServiceImpl", "enterChatOrThreadForNotification: both chatId and threadId are null");
        return;
    L65:
        if (r15.length() <= 0) goto L67;
        boolean r9 = true;
    L68:
        if (r9 != true) goto L70;
        r2 = true;
        goto L70
    L67:
        r9 = false;
        goto L68
    L48:
        if (r14.length() <= 0) goto L50;
        boolean r10 = true;
    L51:
        if (r10 != true) goto L53;
        r7 = true;
        goto L54
    L50:
        r10 = false;
        goto L51
    }
}
