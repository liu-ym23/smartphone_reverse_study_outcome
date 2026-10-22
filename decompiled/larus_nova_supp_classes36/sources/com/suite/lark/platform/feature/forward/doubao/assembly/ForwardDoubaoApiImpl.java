package com.suite.lark.platform.feature.forward.doubao.assembly;

import android.content.Context;
import android.os.SystemClock;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardDoubaoContent;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardScene;
import com.suite.lark.platform.feature.forward.doubao.i;
import com.suite.lark.platform.feature.forward.doubao.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.GroupingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKUserScope
public final class ForwardDoubaoApiImpl implements mpc.f {
    public static final /* synthetic */ int c = 0;
    public final CoroutineScope a;
    public final g b;

    public static final class a {
    }

    static {
    }

    @Inject
    public ForwardDoubaoApiImpl() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.b = new g();
    }

    @Override // mpc.f
    public final void B(List<byte[]> r8) {
        Intrinsics.checkNotNullParameter(r8, "serMessages");
        if (((ArrayList) r8).isEmpty() == false) goto L6;
        Log.w("ForwardDoubaoApiImpl", "deleteLarkMessagesInDoubao ignored: serMessages is empty");
        return;
    L6:
        BuildersKt.launch$default(this.a, null, null, new ForwardDoubaoApiImpl$deleteLarkMessagesInDoubao$1(r8, null), 3, null);
    }

    public static final npc.c a(ForwardDoubaoApiImpl r5, SearchBaseInfo r6) {
        r5.getClass();
        boolean r7 = r6 instanceof SearchChatterInfo;
        if (r7 == false) goto L7;
        SearchChatterInfo r0 = (SearchChatterInfo) r6;
        String r1 = r0.getTitle();
        if (r1 != null) goto L9;
        r1 = r0.getName();
    L9:
        if (r7 == false) goto L12;
        String r8 = ((SearchChatterInfo) r6).getP2pChatId();
        if (r8 == null) goto L12;
    L13:
        npc.c r2 = new npc.c();
        String r3 = r6.getId();
        if (r3 != null) goto L16;
        r3 = "";
    L16:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.a = r3;
        String r4 = r6.getAvatarKey();
        if (r4 != null) goto L19;
        r4 = "";
    L19:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r2.b = r4;
        if (r1 != null) goto L22;
        r1 = "";
    L22:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r2.c = r1;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r2.f = r8;
        if ((r6 instanceof SearchChatterInfo) == false) goto L26;
    L27:
        int r9 = 1;
    L38:
        r2.e = r9;
        return r2;
    L26:
        if ((r6 instanceof SearchShieldP2PChatInfo) == true) goto L27;
        if ((r6 instanceof SearchChatInfo) == false) goto L32;
        r9 = 2;
        goto L38
    L32:
        if ((r6 instanceof SearchThreadInfo) == false) goto L34;
    L37:
        r9 = 3;
        goto L38
    L34:
        if ((r6 instanceof SearchReplyInThreadInfo) == true) goto L37;
        r9 = 0;
    L12:
        r8 = "";
        goto L13
    L7:
        r1 = r6.getTitle();
        goto L9
    }

    @Override // mpc.f
    public final boolean i1(Context r2, npc.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "request");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(Boolean.valueOf(opc.d.a(r2, r3)));     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L12;
        Log.e("ForwardDoubaoApiImpl", "startFileForward failed", r5);
        r4 = Boolean.FALSE;
    L12:
        return ((Boolean) r4).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // mpc.f
    public final void o8(Context r2, npc.d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "template");
        v.a(r2, r3);
    }

    @Override // mpc.f
    public final void cc(ForwardScene r15, mpc.g r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r15, "scene");
        Intrinsics.checkNotNullParameter(r16, "callback");
        long r2 = SystemClock.elapsedRealtime();
        IncludeConfig.a r0 = new IncludeConfig.a();
        EntityItem.a r1 = new EntityItem.a();
        r1.f(new UserConfig.a().a());
        r0.a(r1.c());
        EntityItem.a r3 = new EntityItem.a();
        r3.d(new GroupConfig.a().a());
        r0.a(r3.c());
        IncludeConfig r4 = r0.b();
        BuildersKt.launch$default(this.a, null, null, new ForwardDoubaoApiImpl$getRecentForwardList$1(r2, r4, r17, r15, this, r16, null), 3, null);
    }

    @Override // mpc.f
    public final void gf(final Context r19, ForwardDoubaoContent r20, final List r21, final u48.b r22) {
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r20, "forwardContent");
        Intrinsics.checkNotNullParameter(r21, "target");
        Intrinsics.checkNotNullParameter(r22, "callBack");
        final long r5 = SystemClock.elapsedRealtime();
        List<Long> r7 = r20.getDoubaoMsgIds();
        if (r7.isEmpty() == false) goto L6;
        Log.w("ForwardDoubaoApiImpl", "send failed: doubaoMsgIds is empty, targets=" + ((ArrayList) r21).size());
        r22.onFailure(-1, "doubaoMsgIds is empty");
        return;
    L6:
        ArrayList r8 = (ArrayList) r21;
        if (r8.isEmpty() == false) goto L10;
        Log.w("ForwardDoubaoApiImpl", "send failed: target is empty, msgIds=" + r7.size());
        r22.onFailure(-1, "target is empty");
        return;
    L10:
        final String r11 = StringsKt.trim(r20.getTextContent()).toString();
        i.a.update(r20);
        Map r12 = GroupingKt.eachCount(new e(r21));
        if (r21.isEmpty() == false) goto L13;
        int r15 = 0;
    L28:
        StringBuilder r9 = new StringBuilder("send start: msgIds=");
        r9.append(r7.size());
        r9.append(", targets=");
        r9.append(r8.size());
        r9.append(", noteLen=");
        r9.append(r11.length());
        r9.append(", targetTypes=");
        r9.append(r12);
        r9.append(", preloadedP2pChatCount=");
        r9.append(r15);
        r9.append(", doubaoDataSize=");
        byte[] r1 = r20.getDoubaoData();
        if (r1 == null) goto L31;
        int r2 = r1.length;
    L32:
        r9.append(r2);
        Log.i("ForwardDoubaoApiImpl", r9.toString());
        final g r10 = this.b;
        final Function0<Unit> r3 = new ForwardDoubaoApiImpl$send$1(r5, r22);
        final Function1<ErrorResult, Unit> r13 = new ForwardDoubaoApiImpl$send$2(r5, r22);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r11, "note");
        Intrinsics.checkNotNullParameter(r21, "targets");
        Intrinsics.checkNotNullParameter(r3, "onSuccess");
        Intrinsics.checkNotNullParameter(r13, "onFailed");
        final Function1<List<? extends SearchBaseInfo>, Unit> r4 = new ForwardDoubaoMergeForwardSender$sendMergeForward$1(r19, r11, r3, r13);
        int r0 = r8.size();
        if (r0 != 0) goto L35;
        r4.invoke(CollectionsKt.emptyList());
        return;
    L35:
        final SearchBaseInfo[] r6 = new SearchBaseInfo[r0];
        final ArrayList r14 = new ArrayList();
        int r16 = r21.size();
        int r17 = 0;
    L36:
        if (r17 >= r16) goto L57;
        npc.c r18 = (npc.c) ListProtector.get(r21, r17);
        int r23 = r18.e;
        if (r23 != 1) goto L40;
        String r24 = r18.a;
        if (StringsKt.isBlank(r24) == true) goto L50;
        String r110 = r18.f;
        if ((!StringsKt.isBlank(r110)) == false) goto L54;
        SearchChatterInfo r111 = new SearchChatterInfo();
        r111.setId(r24);
        r111.setP2pChatId(r110);
        r111.setTitle(r18.c);
        r111.setAvatarKey(r18.b);
        r6[r17] = r111;
    L55:
        r17 = r17 + 1;
        goto L36
    L54:
        r14.add(Integer.valueOf(r17));
        goto L55
    L50:
        r13.invoke(new ErrorResult(-1, "chatterId is empty"));
        return;
    L40:
        if (r23 != 2) goto L42;
    L44:
        String r25 = r18.a;
        if (StringsKt.isBlank(r25) == true) goto L46;
        SearchChatInfo r26 = new SearchChatInfo();
        r26.setId(r25);
        r26.setTitle(r18.c);
        r26.setAvatarKey(r18.b);
        Unit r27 = Unit.INSTANCE;
        r6[r17] = r26;
        goto L55
    L46:
        r13.invoke(new ErrorResult(-1, "chatId is empty"));
        return;
    L42:
        if (r23 == 3) goto L44;
        r13.invoke(new ErrorResult(-1, "unknown targetType: " + r18.e));
        return;
    L57:
        if (r14.isEmpty() == false) goto L59;
        r4.invoke(ArraysKt.filterNotNull(r6));
        return;
    L59:
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r29 = r14.iterator();
    L61:
        if (r29.hasNext() == false) goto L63;
        r28.add(((npc.c) ListProtector.get(r21, ((Number) r29.next()).intValue())).a);
        goto L61
    L63:
        ImSdkService.b().C2(CollectionsKt.distinct(r28), new ForwardDoubaoMergeForwardSender$adaptForwardTargetsToSearchBaseInfos$2(r14, r4, r6, r21, r13, r10));
        return;
    L31:
        r2 = 0;
        goto L32
    L13:
        Iterator r112 = r21.iterator();
        int r113 = 0;
    L15:
        if (r112.hasNext() == false) goto L27;
        npc.c r114 = (npc.c) r112.next();
        if (r114.e == 1) goto L19;
    L21:
        boolean r30 = false;
    L22:
        if (r30 == false) goto L15;
        r113 = r113 + 1;
        if (r113 >= 0) goto L15;
        CollectionsKt.throwCountOverflow();
        goto L15
    L19:
        if ((!StringsKt.isBlank(r114.f)) == false) goto L21;
        r30 = true;
        goto L22
    L27:
        r15 = r113;
        goto L28
    }

    @Override // mpc.f
    public final boolean g1(Context r3, npc.a r4, List r5, String r6, u48.c r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "targets");
        Intrinsics.checkNotNullParameter(r6, "note");
        Intrinsics.checkNotNullParameter(r7, "callback");
        if (r4.a() == true) goto L5;
        return false;
    L5:
        if (((ArrayList) r5).isEmpty() == true) goto L24;
        int r1 = opc.d.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        UICallbackExecutor.execute(new opc.c(r3));
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L10
        com.suite.lark.platform.feature.forward.doubao.assembly.a r9 = com.suite.lark.platform.feature.forward.doubao.assembly.a.a;     // Catch: Throwable -> L10
        f r0 = new f(r7);     // Catch: Throwable -> L10
        r9.getClass();     // Catch: Throwable -> L10
        Object r10 = Result.constructor-impl(Boolean.valueOf(com.suite.lark.platform.feature.forward.doubao.assembly.a.a(r4, r5, r6, r0)));     // Catch: Throwable -> L10
    L12:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L16;
        Log.e("ForwardDoubaoApiImpl", "sendFile failed before request", r11);
        r10 = Boolean.FALSE;
    L16:
        boolean r12 = ((Boolean) r10).booleanValue();
        if (r12 == true) goto L19;
        int r13 = opc.d.a;
        UICallbackExecutor.post(opc.b.a);
    L19:
        return r12;
    L10:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L24:
        return false;
    }

    @Override // mpc.f
    public final void g8(Context r2, ImageView r3, String r4, String r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "imageView");
        Intrinsics.checkNotNullParameter(r4, "avatarKey");
        Intrinsics.checkNotNullParameter(r5, "entityId");
        if (StringsKt.isBlank(r4) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r5) == false) goto L8;
        return;
    L8:
        if (r6 > 0) goto L11;
        r6 = -1;
    L11:
        if (r7 > 0) goto L14;
        r7 = -1;
    L14:
        AvatarImage r8 = AvatarImage.Builder.obtain(r4, r5, r6, r7).isOnlyLocal(false).build();
        IRequestCreator r9 = ImageLoader.with(r2).load(r8);
        r9.transform(new CircleCrop());
        if (r6 <= 0) goto L18;
        if (r7 <= 0) goto L18;
        r9.override(r6, r7);
    L18:
        r9.dontAnimate(true);
        r9.into(r3);
    }
}
