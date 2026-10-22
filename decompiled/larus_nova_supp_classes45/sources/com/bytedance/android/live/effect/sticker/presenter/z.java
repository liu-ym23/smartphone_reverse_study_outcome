package com.bytedance.android.live.effect.sticker.presenter;

import android.text.TextUtils;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchFavoriteList;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import com.ss.android.ugc.effectmanager.effect.model.net.FetchFavoriteListResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z extends f {
    public final LiveEffectContextFactoryDelegate$Type d;
    public final List<com.bytedance.android.live.effect.api.k.i> e;
    public final Map<String, EffectChannelResponse> f;
    public final Map<String, EffectCategoryResponse> g;
    public final Map<String, com.bytedance.android.live.effect.api.k.h> h;
    public Boolean i;

    public class a implements IFetchFavoriteList {
        public final /* synthetic */ String a;
        public final /* synthetic */ z b;

        public final void onFailed(ExceptionResult r1) {
        }

        public final void onSuccess(Object r3) {
            FetchFavoriteListResponse r4 = (FetchFavoriteListResponse) r3;
            if (r4 == null) goto L13;
            this.b.r(this.a);
            Map<String, EffectCategoryResponse> r0 = this.b.g;
            HashMap r1 = (HashMap) r0;
            EffectCategoryResponse r2 = (EffectCategoryResponse) r1.get(this.a);
            if (r2 == null) goto L11;
            r2.setTotalEffects(r4.getEffects());
            r2.setTagsUpdateTime("0");
            Map<String, com.bytedance.android.live.effect.api.k.h> r5 = this.b.h;
            HashMap r6 = (HashMap) r5;
            com.bytedance.android.live.effect.api.k.h r7 = (com.bytedance.android.live.effect.api.k.h) r6.get(this.a);
            if (r7 == null) goto L12;
            r7.a(r2);
            return;
        L12:
            return;
        L11:
            return;
        }

        public a(z r1, String r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements IFetchEffectListListener {
        public final /* synthetic */ IFetchEffectListener a;

        public b(IFetchEffectListener r1) {
            this.a = r1;
        }

        public final void onFail(ExceptionResult r3) {
            this.a.onFail(null, r3);
        }

        public final void onSuccess(Object r3) {
            List r4 = (List) r3;
            if (r4 != null) goto L5;
        L7:
            this.a.onFail(null, new ExceptionResult(1));
            return;
        L5:
            if (r4.isEmpty() == true) goto L7;
            this.a.onSuccess((Effect) ListProtector.get(r4, 0));
        }
    }

    public z(LiveEffectContextFactoryDelegate$Type r2) {
        super(r2);
        this.i = Boolean.FALSE;
        this.d = r2;
        this.e = new ArrayList();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new HashMap();
        new HashMap();
        new HashMap();
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void c(String r3) {
        EffectManager r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r(r3);
        r0.fetchFavoriteList(r3, new a(this, r3));
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final EffectCategoryResponse h(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return (EffectCategoryResponse) ((HashMap) this.g).get(r2);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void i(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        ((HashMap) this.h).remove(r2);
    }

    public final void r(String r4) {
        if (((HashMap) this.g).containsKey(r4) == false) goto L5;
        return;
    L5:
        Map<String, EffectCategoryResponse> r0 = this.g;
        EffectCategoryResponse r1 = new EffectCategoryResponse();
        r1.setId(GamePromoteDataContext.GAME_TYPE_MOBILE);
        r1.setName(s1.B(2131916362));
        r1.setKey("");
        ((HashMap) r0).put(r4, r1);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void a(String r11, int r12) {
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r0 = com.bytedance.android.live.effect.api.u.a;
        com.bytedance.android.live.effect.api.u.b(this.d).a().n(r11, false, "", r12, 0, false, null, false);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void d(String r2, IFetchEffectListener r3) {
        IFetchEffectListListener r0 = new b(r3);
        ArrayList r4 = new ArrayList();
        r4.add(r2);
        j(r4, r0);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void j(List<String> r4, IFetchEffectListListener r5) {
        this.a.fetchEffectList(r4, false, null, r5);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void k(String r4, int r5) {
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r0 = com.bytedance.android.live.effect.api.u.a;
        com.bytedance.android.live.effect.api.u.b(this.d).a().r(r4, "hot", r5, null);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void l(String r2, com.bytedance.android.live.effect.api.k.i r3) {
        p(r2, r3, false);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void m(String r2, StickerDataViewModel.C03171 r3) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        ((HashMap) this.h).put(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final boolean o(String r3, Sticker r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        if (r4 != null) goto L7;
        return false;
    L7:
        Effect r5 = r4.getEffect();
        if (r5 != null) goto L10;
        return false;
    L10:
        EffectCategoryResponse r6 = (EffectCategoryResponse) ((HashMap) this.g).get(r3);
        if (r6 != null) goto L13;
        return false;
    L13:
        List r7 = r6.getTotalEffects();
        if (r7 != null) goto L17;
        return false;
    L17:
        return r7.contains(r5);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void f(String r5, Sticker r6, boolean r7) {
        if (this.i.booleanValue() == false) goto L5;
        return;
    L5:
        if (s(r5, r6, r7) == false) goto L10;
        String r0 = r6.getEffect().getEffectId();
        this.i = Boolean.TRUE;
        this.a.modifyFavoriteList(r5, r0, Boolean.valueOf(r7), new y(this, r5, r7, r6));
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void p(String r8, com.bytedance.android.live.effect.api.k.i r9, boolean r11) {
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r0 = com.bytedance.android.live.effect.api.u.a;
        com.bytedance.android.live.effect.api.u.a(this.d).d().a().a(r8, r9, true, r11, false, false);
    }

    public final boolean s(String r5, Sticker r6, boolean r7) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        if (r6 == null) goto L18;
        Effect r8 = r6.getEffect();
        if (r8 == null) goto L18;
        EffectCategoryResponse r0 = (EffectCategoryResponse) ((HashMap) this.g).get(r5);
        if (r0 != null) goto L12;
        return false;
    L12:
        ArrayList r2 = new ArrayList(r0.getTotalEffects());
        if (r7 == false) goto L15;
        ListProtector.add(r2, 0, r8);
    L16:
        r0.setTotalEffects(r2);
        ((HashMap) this.g).put(r5, r0);
        return true;
    L15:
        r2.remove(r8);
    L18:
        return false;
    }
}
