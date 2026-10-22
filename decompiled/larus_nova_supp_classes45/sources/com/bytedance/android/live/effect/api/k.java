package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener;
import com.ss.android.ugc.effectmanager.effect.listener.IUpdateTagListener;
import com.ss.android.ugc.effectmanager.effect.model.CategoryInfoModelList;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import com.ss.android.ugc.effectmanager.effect.model.PanelInfoModel;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface k {

    public interface a {
        void a(List<Effect> r1, EffectDataFetchCacheType r2);

        void onFetchFailed();
    }

    public interface b {
        void a(List<Effect> r1, EffectDataFetchCacheType r2);

        void onFetchFailed();
    }

    public interface c {
        void a(CategoryInfoModelList r1, EffectDataFetchCacheType r2);

        void onFetchFailed();
    }

    public interface d {
        void a(PanelInfoModel r1, EffectDataFetchCacheType r2);

        void onFetchFailed();
    }

    public interface e {
        void onFetchFailed();

        void onFetchSuccess(List<Effect> r1);
    }

    public interface f {
        void O1(String r1, Sticker r2);

        void Z(String r1, Sticker r2);

        void z0(String r1, Sticker r2, ExceptionResult r3);
    }

    public interface g extends f {
        void onProgress(int r1, long r2);
    }

    public interface h {
        void a(EffectCategoryResponse r1);
    }

    public interface i {
        void a(EffectChannelResponse r1);

        void b();
    }

    public interface j extends i {
        void c(EffectChannelResponse r1, EffectDataFetchCacheType r2);
    }

    void a(String r1, int r2);

    void b(String r1, String r2, IIsTagNeedUpdatedListener r3);

    void c(String r1);

    void d(String r1, IFetchEffectListener r2);

    boolean e(Effect r1);

    void f(String r1, Sticker r2, boolean r3);

    void g(String r1, Sticker r2, f r3);

    EffectCategoryResponse h(String r1);

    void i(String r1);

    void j(List<String> r1, IFetchEffectListListener r2);

    void k(String r1, int r2);

    void l(String r1, i r2);

    void m(String r1, StickerDataViewModel.C03171 r2);

    void n(String r1, String r2, IUpdateTagListener r3);

    boolean o(String r1, Sticker r2);

    void p(String r1, i r2, boolean r3);

    boolean q(Sticker r1);
}
