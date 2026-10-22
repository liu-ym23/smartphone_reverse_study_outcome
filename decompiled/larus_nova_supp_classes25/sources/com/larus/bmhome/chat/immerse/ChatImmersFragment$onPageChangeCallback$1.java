package com.larus.bmhome.chat.immerse;

import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.floating.BottomFloatingButtonAction;
import com.larus.bmhome.chat.layout.widget.NestedScrollableContainer;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.databinding.LarusPageChatImmersiveBinding;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/larus/bmhome/chat/immerse/ChatImmersFragment$onPageChangeCallback$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrolled", "", "position", "", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onPageScrollStateChanged", "state", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatImmersFragment$onPageChangeCallback$1 extends ViewPager2.OnPageChangeCallback {
    public final /* synthetic */ ChatImmersFragment a;

    public ChatImmersFragment$onPageChangeCallback$1(ChatImmersFragment r1) {
        this.a = r1;
    }

    public final void onPageScrollStateChanged(int r9) {
        if (r9 == 0) goto L21;
        ChatImmersFragment r2 = this.a;
        int r3 = ChatImmersFragment.I;
        r2.getClass();
        FLogger.a.d("ChatImmersFragment", "startScroll, immersiveFpsOptimizeEnable");
        LarusPageChatImmersiveBinding r0 = r2.j;
        RecyclerView r4 = null;
        if (r0 == null) goto L9;
        ViewPager2 r1 = r0.c;
        if (r1 == null) goto L9;
        View r5 = r1.getChildAt(0);
    L11:
        if ((r5 instanceof RecyclerView) == false) goto L13;
        r4 = (RecyclerView) r5;
    L13:
        if (r4 == null) goto L15;
        r4.setItemViewCacheSize(5);
    L15:
        LarusPageChatImmersiveBinding r6 = r2.j;
        if (r6 == null) goto L20;
        ViewPager2 r7 = r6.c;
        if (r7 == null) goto L20;
        r7.setOffscreenPageLimit(-1);
    L20:
        this.a.F.d();
    L27:
        int r8 = Integer.MAX_VALUE;
        boolean r10 = true;
        if (r9 != 1) goto L41;
        ChatImmersFragment r11 = this.a;
        int r12 = r11.s;
        ChatImmersViewPagerAdapter r13 = r11.l;
        if (r13 == null) goto L34;
        List<Bundle> r14 = r13.z2();
        if (r14 == null) goto L34;
        int r15 = r14.size() - 1;
    L35:
        if (r12 != r15) goto L41;
        final ChatImmersFragment r16 = this.a;
        LarusPageChatImmersiveBinding r17 = r16.j;
        if (r17 == null) goto L41;
        ConstraintLayout r18 = r17.a;
        if (r18 == null) goto L41;
        r18.postDelayed(new s(r16), 200);
    L34:
        r15 = Integer.MAX_VALUE;
    L41:
        ChatImmersViewModel r19 = this.a.ba0();
        if (r19 == null) goto L46;
        MutableLiveData<Integer> r20 = r19.getViewPagerState();
        if (r20 == null) goto L46;
        r20.setValue(Integer.valueOf(r9));
    L46:
        ChatImmersFragment r21 = this.a;
        int r22 = r21.s;
        ChatImmersViewPagerAdapter r23 = r21.l;
        if (r23 == null) goto L51;
        List<Bundle> r24 = r23.z2();
        if (r24 == null) goto L51;
        r8 = r24.size() - 1;
    L51:
        if (r22 != r8) goto L53;
        boolean r25 = true;
    L54:
        if (r25 == false) goto L67;
        ChatImmersViewModel r26 = this.a.ba0();
        if (r26 != null) goto L58;
    L60:
        r10 = false;
    L61:
        if (r10 == false) goto L67;
        ChatImmersViewModel r27 = this.a.ba0();
        if (r27 == null) goto L67;
        MutableLiveData<Boolean> r28 = r27.getDataLoading();
        if (r28 == null) goto L67;
        Intrinsics.areEqual(r28.getValue(), Boolean.TRUE);
        goto L67
    L58:
        if (r26.getHasMore() != true) goto L60;
    L67:
        super.onPageScrollStateChanged(r9);
        return;
    L53:
        r25 = false;
    L9:
        r5 = null;
        goto L11
    L21:
        ChatImmersFragment r29 = this.a;
        int r30 = ChatImmersFragment.I;
        r29.getClass();
        FLogger.a.d("ChatImmersFragment", "stopScroll, immersiveFpsOptimizeEnable");
        LarusPageChatImmersiveBinding r31 = r29.j;
        if (r31 == null) goto L26;
        ViewPager2 r32 = r31.c;
        if (r32 == null) goto L26;
        r32.setOffscreenPageLimit(2);
    L26:
        this.a.F.f();
        goto L27
    }

    public final void onPageSelected(int r33) {
        if (i0.b == false) goto L12;
        ChatImmersFragment r0 = this.a;
        int r2 = ChatImmersFragment.I;
        r0.da0();
        ChatImmersViewPagerAdapter r1 = this.a.l;
        if (r1 == null) goto L198;
        int r3 = r1.d;
        if (r3 == (-1)) goto L199;
        r1.notifyItemChanged(r3);     // Catch: Throwable -> L10
        return;
    L10:
        FLogger.a.e("immersAdapter", "Try to updating the ViewHolder when RecyclerView scrolls or layouts");
        return;
    L199:
        return;
    L198:
        return;
    L12:
        super.onPageSelected(r33);
        boolean r4 = true;
        Boolean r6 = null;
        if (r33 <= 0) goto L54;
        ChatImmersFragment r5 = this.a;
        int r7 = ChatImmersFragment.I;
        ChatImmersViewModel r8 = r5.ba0();
        if (r8 == null) goto L21;
        MutableLiveData<List<RecommendBot>> r9 = r8.getFeedData();
        if (r9 == null) goto L21;
        List r10 = (List) r9.getValue();
        if (r10 == null) goto L21;
        int r11 = r10.size();
    L22:
        if (r33 >= r11) goto L54;
        ChatImmersFragment r12 = this.a;
        if (r33 <= r12.t) goto L54;
        ChatImmersViewModel r13 = r12.ba0();
        if (r13 == null) goto L54;
        MutableLiveData<List<RecommendBot>> r14 = r13.getFeedData();
        if (r14 == null) goto L54;
        List r15 = (List) r14.getValue();
        if (r15 == null) goto L54;
        RecommendBot r16 = (RecommendBot) ListProtector.get(r15, r33);
        if (r16 == null) goto L54;
        ChatImmersFragment r17 = this.a;
        JSONObject r18 = IAIChatControlTraceService.a.Xb(r16.a);
        r18.put("bot_id", r16.o());
        r18.put("item_id", r16.o());
        r17.getClass();
        Integer r19 = r16.r();
        if (r19 != null) goto L37;
    L39:
        if (r19 != null) goto L42;
    L51:
        String r20 = "other_default";
    L52:
        r18.put("chat_type", r20);
        r18.put("group_type", "private");
        r18.put("is_immersive_background", IAIChatService.a.j8().a(r16));
        r18.put("recommend_from", r17.ca0());
        r18.put("current_page", "chat");
        o3.c(null, null, null, null, null, r17.b(), null, null, null, null, null, null, null, null, null, null, null, null, null, r18, null, 6291391);
        goto L54
    L42:
        if (r19.intValue() != 0) goto L51;
        BotCreatorInfo r21 = r16.j();
        if (r21 == null) goto L46;
        String r22 = r21.getId();
    L48:
        if (Intrinsics.areEqual(r22, AccountService.a.getUserId()) == false) goto L50;
        r20 = "self_created";
        goto L52
    L50:
        r20 = "others_created";
        goto L52
    L46:
        r22 = null;
        goto L48
    L37:
        if (r19.intValue() != 1) goto L39;
        r20 = "default";
    L21:
        r11 = 0;
    L54:
        if (this.a.s != r33) goto L56;
    L104:
        ChatFragment r23 = this.a.aa0(r33);
        if (r23 == null) goto L111;
        t1a.b r24 = r23.WF();
        if (r24 == null) goto L111;
        com.larus.bmhome.chat.component.immerse.a r25 = r24.getAbility(com.larus.bmhome.chat.component.immerse.a.class);
        if (r25 == null) goto L111;
        r25.MA();
    L111:
        ChatImmersFragment r26 = this.a;
        r26.s = r33;
        if (r33 <= r26.t) goto L114;
        r26.t = r33;
    L114:
        ChatImmersViewModel r27 = r26.ba0();
        if (r27 == null) goto L129;
        MutableLiveData<Pair<Integer, String>> r28 = r27.getCurrentPage();
        if (r28 == null) goto L129;
        Integer r110 = Integer.valueOf(r33);
        ChatImmersViewPagerAdapter r111 = this.a.l;
        if (r111 == null) goto L127;
        List<Bundle> r112 = r111.z2();
        if (r112 == null) goto L127;
        Bundle r113 = (Bundle) ListProtector.get(r112, r33);
        if (r113 == null) goto L127;
        String r114 = r113.getString("argBotId", "");
        if (r114 == null) goto L127;
    L128:
        r28.setValue(new Pair(r110, r114));
    L127:
        r114 = "";
    L129:
        ChatImmersFragment r29 = this.a;
        ChatImmersViewPagerAdapter r115 = r29.l;
        if (r115 == null) goto L136;
        List<Bundle> r116 = r115.z2();
        if (r116 == null) goto L136;
        Bundle r117 = (Bundle) ListProtector.get(r116, r33);
        if (r117 == null) goto L136;
        String r30 = r117.getString("argBotId", "");
    L137:
        r29.H = r30;
        if (com.larus.utils.o0.d(this.a.H) == false) goto L154;
        ChatImmersFragment r31 = this.a;
        if (Intrinsics.areEqual(r31.H, r31.G) == true) goto L154;
        if (com.larus.utils.o0.d(this.a.G) == false) goto L153;
        ChatImmersFragment r32 = this.a;
        String r34 = r32.H;
        String r35 = r32.G;
        JSONObject r36 = new JSONObject();
        Intrinsics.checkNotNullParameter(r36, "params");
        if (r34 != null) goto L192;
    L148:
        if (r35 == null) goto L152;
        r36.put("from_bot_id", r35);     // Catch: JSONException -> L146
    L146:
        e = move-exception;
        FLogger.a.e("ImmersiveEventHelper", "error in ImmersiveEventHelper immersiveBotChatSlide " + e.getLocalizedMessage());
    L152:
        TrackParams r37 = new TrackParams().merge(r36);
        by7.a r38 = new by7.a("immersive_bot_chat_slide");
        r38.a.merge(r37);
        r38.b();
        goto L153
    L192:
        r36.put("bot_id", r34);     // Catch: JSONException -> L146
    L153:
        ChatImmersFragment r39 = this.a;
        r39.G = r39.H;
    L154:
        ChatImmersFragment r40 = this.a;
        ChatImmersViewPagerAdapter r41 = r40.l;
        if (r41 != null) goto L157;
    L159:
        boolean r42 = false;
    L160:
        if (r42 == true) goto L167;
        ChatImmersViewPagerAdapter r43 = this.a.l;
        if (r43 == null) goto L164;
        int r44 = r43.getItemCount() - 10;
    L165:
        if (r33 < r44) goto L167;
        boolean r45 = true;
    L168:
        FLogger r46 = FLogger.a;
        int r47 = ChatImmersFragment.I;
        StringBuilder r48 = new StringBuilder("onPageSelected, needPreLoad = ");
        r48.append(r45);
        r48.append(", lastItemCount = ");
        r48.append(this.a.A);
        r48.append(", itemCount = ");
        ChatImmersViewPagerAdapter r49 = this.a.l;
        if (r49 == null) goto L171;
        Integer r50 = Integer.valueOf(r49.getItemCount());
    L172:
        r48.append(r50);
        r48.append(", position = ");
        r48.append(r33);
        r48.append(", hasMore = ");
        ChatImmersViewModel r51 = this.a.ba0();
        if (r51 == null) goto L175;
        r6 = Boolean.valueOf(r51.getHasMore());
    L175:
        r48.append(r6);
        r46.d("ChatImmersFragment", r48.toString());
        if (r45 == false) goto L201;
        ChatImmersFragment r52 = this.a;
        ChatImmersViewPagerAdapter r53 = r52.l;
        if (r53 == null) goto L180;
        int r54 = r53.getItemCount();
    L181:
        r52.A = r54;
        ChatImmersViewModel r55 = this.a.ba0();
        if (r55 != null) goto L184;
    L186:
        r4 = false;
    L187:
        if (r4 == false) goto L202;
        ChatImmersViewModel r56 = this.a.ba0();
        if (r56 == null) goto L203;
        r56.loadFeedData(this.a.ca0(), DowngradeSource.ENTER_PAGE);
        return;
    L203:
        return;
    L202:
        return;
    L184:
        if (r55.getHasMore() != true) goto L186;
    L180:
        r54 = 0;
        goto L181
    L201:
        return;
    L171:
        r50 = null;
        goto L172
    L164:
        r44 = 0;
    L167:
        r45 = false;
        goto L168
    L157:
        if (r40.A != r41.getItemCount()) goto L159;
        r42 = true;
    L136:
        r30 = null;
        goto L137
    L56:
        if (z2.a.V1() == false) goto L90;
        ChatImmersFragment r57 = this.a;
        ChatFragment r58 = r57.aa0(r57.s);
        if (r58 == null) goto L62;
        t1a.b r59 = r58.WF();
        if (r59 == null) goto L62;
        com.larus.bmhome.chat.component.immerse.a r60 = (com.larus.bmhome.chat.component.immerse.a) r59.getAbility(com.larus.bmhome.chat.component.immerse.a.class);
    L63:
        if (r60 != null) goto L65;
    L67:
        boolean r61 = false;
    L68:
        if (r61 == false) goto L83;
        FLogger r62 = FLogger.a;
        int r118 = ChatImmersFragment.I;
        r62.d("ChatImmersFragment", "onPageSelected, switchHistoryCheckState");
        r60.aq(true, false);
        com.larus.bmhome.instruction.g r63 = r58.WF().getAbility(com.larus.bmhome.instruction.g.class);
        if (r63 == null) goto L72;
        r63.K90();
    L72:
        LarusPageChatBinding r64 = r58.u;
        if (r64 == null) goto L83;
        NestedScrollableContainer r65 = r64.o;
        if (r65 == null) goto L83;
        Result.Companion r66 = Result.Companion;     // Catch: Throwable -> L81
        if (r65.getChildCount() < 3) goto L83;
        r65.getChildAt(0).setAlpha(0.0f);     // Catch: Throwable -> L81
        r65.getChildAt(1).setAlpha(1.0f);     // Catch: Throwable -> L81
        r65.getChildAt(2).setAlpha(0.0f);     // Catch: Throwable -> L81
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        Result.Companion r67 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L83:
        ChatFragment r68 = this.a.aa0(r33);
        if (r68 == null) goto L90;
        t1a.b r69 = r68.WF();
        if (r69 == null) goto L90;
        ld8.n r70 = (ld8.n) r69.getAbility(ld8.n.class);
        if (r70 == null) goto L90;
        r70.m60(BottomFloatingButtonAction.SCROLL_DOWN);
        goto L90
    L65:
        if (r60.hV() != true) goto L67;
        r61 = true;
    L62:
        r60 = null;
    L90:
        ChatImmersFragment r71 = this.a;
        ChatFragment r72 = r71.aa0(r71.s);
        if (r72 == null) goto L97;
        t1a.b r73 = r72.WF();
        if (r73 == null) goto L97;
        xa8.b r74 = r73.getAbility(xa8.b.class);
        if (r74 == null) goto L97;
        r74.hd();
    L97:
        ChatFragment r75 = this.a.aa0(r33);
        if (r75 == null) goto L104;
        t1a.b r76 = r75.WF();
        if (r76 == null) goto L104;
        ry8.b r77 = r76.getAbility(ry8.b.class);
        if (r77 == null) goto L104;
        r77.M9();
        goto L104
    }

    public final void onPageScrolled(int r5, float r6, int r7) {
        ChatImmersFragment r0 = this.a;
        int r1 = ChatImmersFragment.I;
        r0.getClass();
        if (0.0f < r6) goto L5;
        this.a.getClass();
    L6:
        ChatImmersFragment r2 = this.a;
        r2.getClass();
        i0 r3 = i0.a;
        if (i0.c() != 0) goto L9;
        int r4 = com.larus.utils.m0.a;
        int r8 = com.larus.utils.m0.b(r2.getContext());
    L11:
        if (r7 <= (r8 / 2)) goto L13;
        int r9 = r8 - r7;
    L14:
        ChatImmersViewModel r10 = this.a.ba0();
        if (r10 == null) goto L19;
        MutableLiveData<Pair<Integer, Integer>> r11 = r10.getSlideDistance();
        if (r11 == null) goto L19;
        r11.setValue(new Pair(Integer.valueOf(r9), Integer.valueOf(r5)));
    L19:
        super.onPageScrolled(r5, r6, r7);
        return;
    L13:
        r9 = r7;
        goto L14
    L9:
        int r12 = com.larus.utils.m0.a;
        r8 = com.larus.utils.m0.a(r2.getContext());
        goto L11
    L5:
        this.a.getClass();
        goto L6
    }
}
