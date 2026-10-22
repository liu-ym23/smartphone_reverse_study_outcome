package com.ss.android.lark.mention.base.impl.atselector;

import android.text.TextUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIDelayGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.MentionUtils;
import com.ss.android.lark.mention.base.impl.atselector.bean.AtSelectInitData;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.LabelAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.MyAIBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.UserGroupBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.WantAtMemBean;
import com.ss.android.lark.mention.base.impl.atselector.model.ChatAtModel;
import com.ss.android.lark.mention.base.impl.atselector.view.AtView;
import com.ss.android.lark.picker.base.reporter.SearchConsistencyReporter;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import fsb.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AtPresenter extends BasePresenter<d, e, e.a> {
    public final AtSelectInitData a;
    public e b;
    public ChatAtModel c;
    public final int d;
    public String e;
    public String f;
    public String g;
    public final String h;
    public int i;
    public int j;

    public class ViewDelegate implements e.a {
        public final /* synthetic */ AtPresenter a;

        /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.AtPresenter$ViewDelegate$1, reason: invalid class name */
        class AnonymousClass1 implements IGetDataCallback<List<BaseAtBean>> {
            final /* synthetic */ ViewDelegate this$1;

            public AnonymousClass1(ViewDelegate r1) {
                this.this$1 = r1;
            }

            public void onError(ErrorResult r1) {
                arb.a.b.b0();
            }

            public void onSuccess(List<BaseAtBean> r2) {
                ((e) this.this$1.a.getView()).p1(r2);
                arb.a.b.b0();
            }

            public /* bridge */ /* synthetic */ void onError(Object r1) {
                onError((ErrorResult) r1);
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
                onSuccess((List) r1);
            }
        }

        public class a implements RxScheduledExecutor.Producer<com.ss.android.lark.mention.base.impl.atselector.bean.d> {
            public final /* synthetic */ ViewDelegate a;

            public final Object produce() {
                return new com.ss.android.lark.mention.base.impl.atselector.bean.d(new ArrayList(((d) this.a.a.getModel()).N4().values()), ((d) this.a.a.getModel()).g2());
            }

            public a(ViewDelegate r1) {
                this.a = r1;
            }
        }

        public class b implements RxScheduledExecutor.Consumer<com.ss.android.lark.mention.base.impl.atselector.bean.d> {
            public final /* synthetic */ ViewDelegate a;

            public final void consume(Object r2) {
                e r0 = (e) this.a.a.getView();
                r0.j1((com.ss.android.lark.mention.base.impl.atselector.bean.d) r2);
            }

            public b(ViewDelegate r1, String r2) {
                this.a = r1;
            }
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.e.a
        public final boolean o0() {
            return false;
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.e.a
        public final boolean V0() {
            AtSelectInitData r0 = this.a.a;
            if (r0 != null) goto L5;
            return false;
        L5:
            return r0.isEnableAIKnowledge();
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.e.a
        public final void b6() {
            this.a.c.o();
            ChatAtModel r0 = this.a.c;
            if (CollectionUtils.isEmpty(r0.d) == false) goto L5;
            List<BaseAtBean> r1 = new ArrayList();
        L9:
            this.a.b.p1(r1);
            return;
        L5:
            Chat r2 = r0.s();
            if (r2 == null) goto L8;
            boolean r3 = r0.c.isEnableMyAI();
            r1 = r0.d;
            com.ss.android.lark.mention.base.impl.atselector.model.loader.a.b(r2, r3, r1);
            goto L9
        L8:
            r1 = r0.d;
            goto L9
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.e.a
        public final void f6() {
            this.a.c.w();
            ChatAtModel r0 = this.a.c;
            if (CollectionUtils.isEmpty(r0.d) == false) goto L5;
            List<BaseAtBean> r1 = new ArrayList();
        L12:
            this.a.b.p1(r1);
            return;
        L5:
            Iterator r2 = ((ArrayList) r0.d).iterator();
        L7:
            if (r2.hasNext() == false) goto L11;
            if ((((BaseAtBean) r2.next()) instanceof MyAIBean) == false) goto L7;
            r2.remove();
        L11:
            r1 = r0.d;
            goto L12
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.e.a
        public final String n6() {
            return this.a.h;
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.e.a
        public final void onLoadMore() {
            x0(((d) this.a.getModel()).e5());
        }

        public ViewDelegate(AtPresenter r1) {
            this.a = r1;
        }

        private void setResult(final String r4) {
            RxScheduledExecutor.execInIO(new a(this), new b(this, r4), new com.ss.android.lark.mention.base.impl.atselector.b(this, r4));
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.e.a
        public final void V2(int r13) {
            if (r13 == 1) goto L5;
        L33:
            ((e) this.a.getView()).T5(((d) this.a.getModel()).b3());
            return;
        L5:
            if (((d) this.a.getModel()).b3().isEmpty() == true) goto L33;
            Iterator<BaseAtBean> r14 = ((d) this.a.getModel()).b3().values().iterator();
        L8:
            if (r14.hasNext() == false) goto L31;
            BaseAtBean r1 = r14.next();
            if (r1.getType() == 3) goto L8;
            if (r1.getType() == 1) goto L8;
            boolean r2 = r1 instanceof SearchBean;
            boolean r3 = false;
            if (r2 == false) goto L17;
            boolean r8 = ((SearchBean) r1).isOutChatUser();
        L18:
            String r4 = ((d) this.a.getModel()).e5();
            if ((r1 instanceof WantAtMemBean) == false) goto L21;
            WantAtMemBean r5 = (WantAtMemBean) r1;
            String r6 = r5.getSearchLocation();
            String r11 = r5.getGuessType();
            String r10 = r6;
        L22:
            String r7 = com.ss.android.lark.mention.base.b.a().d();
            int r9 = com.ss.android.lark.mention.base.impl.statistics.e.a;
            if (r1.getType() != 2) goto L25;
            boolean r12 = true;
        L26:
            com.ss.android.lark.mention.base.impl.statistics.e.a.b(r12, r1.getId(), r7, r8, !TextUtils.isEmpty(r4), r10, r11);
            boolean r15 = TextUtils.isEmpty(this.a.e);
            this.a.getClass();
            int r16 = com.ss.android.lark.mention.base.a.a;
            if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.myai.new_qa_im_at_ai_fix_mention_searchpanel") == false) goto L30;
            if (r2 == false) goto L30;
            r3 = true;
        L30:
            String r17 = this.a.h;
            Intrinsics.checkNotNullParameter(r1, "entity");
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.android.lark.mention.base.impl.statistics.d(r15, r1, r17, r3));
            String r18 = this.a.h;
            Intrinsics.checkNotNullParameter(r1, "entity");
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.android.lark.mention.base.impl.statistics.b(r1, r18));
            goto L8
        L25:
            r12 = false;
            goto L26
        L21:
            r10 = "";
            r11 = r10;
            goto L22
        L17:
            r8 = false;
            goto L18
        L31:
            setResult(this.a.c.g);
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.e.a
        public final void c5(BaseAtBean r5) {
            ChatAtModel r0 = this.a.c;
            if (r0.f.containsKey(r5.getId()) == false) goto L5;
            r0.f.remove(r5.getId());
            r0.k(r5, false);
        L5:
            Map<String, BaseAtBean> r6 = r0.f;
            this.a.b.D4(r6, false);
            AtPresenter r7 = this.a;
            r7.b.G8(r7.c.d);
            AtPresenter r8 = this.a;
            r8.b.S3(r8.c.e);
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.e.a
        public final void l1(BaseAtBean r11) {
            StringBuilder r0 = new StringBuilder("onItemSinglePick, itemId: ");
            if (r11 == null) goto L5;
            String r1 = r11.getId();
        L6:
            r0.append(r1);
            Log.i("AtPresenter", r0.toString());
            boolean r2 = false;
            if ((r11 instanceof SearchBean) == false) goto L9;
            boolean r5 = ((SearchBean) r11).isOutChatUser();
        L10:
            String r3 = ((d) this.a.getModel()).e5();
            if ((r11 instanceof WantAtMemBean) == false) goto L13;
            WantAtMemBean r4 = (WantAtMemBean) r11;
            String r6 = r4.getSearchLocation();
            String r8 = r4.getGuessType();
            String r7 = r6;
        L14:
            String r9 = com.ss.android.lark.mention.base.b.a().d();
            int r10 = com.ss.android.lark.mention.base.impl.statistics.e.a;
            if (r11.getType() != 2) goto L17;
            boolean r12 = true;
        L18:
            com.ss.android.lark.mention.base.impl.statistics.e.a.b(r12, r11.getId(), r9, r5, !TextUtils.isEmpty(r3), r7, r8);
            boolean r13 = TextUtils.isEmpty(this.a.e);
            this.a.getClass();
            int r14 = com.ss.android.lark.mention.base.a.a;
            if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.myai.new_qa_im_at_ai_fix_mention_searchpanel") == true) goto L21;
        L23:
            String r15 = this.a.h;
            Intrinsics.checkNotNullParameter(r11, "entity");
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.android.lark.mention.base.impl.statistics.d(r13, r11, r15, r2));
            String r16 = this.a.h;
            Intrinsics.checkNotNullParameter(r11, "entity");
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.android.lark.mention.base.impl.statistics.b(r11, r16));
            this.a.c.h(r11);
            setResult(r3);
            return;
        L21:
            if ((r11 instanceof SearchBean) == false) goto L23;
            r2 = true;
            goto L23
        L17:
            r12 = false;
            goto L18
        L13:
            r7 = "";
            r8 = r7;
            goto L14
        L9:
            r5 = false;
            goto L10
        L5:
            r1 = "null";
            goto L6
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.e.a
        public final void l8(BaseAtBean r5) {
            ChatAtModel r0 = this.a.c;
            if (r0.f.containsKey(r5.getId()) == false) goto L5;
            r0.f.remove(r5.getId());
            r0.k(r5, false);
        L5:
            Map<String, BaseAtBean> r6 = r0.f;
            this.a.b.D4(r6, false);
            AtPresenter r7 = this.a;
            r7.b.G8(r7.c.d);
            AtPresenter r8 = this.a;
            r8.b.S3(r8.c.e);
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.e.a
        public final void onSearch(String r3) {
            ChatAtModel r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.g = "";
            r0.h = "";
            ((ArrayList) r0.e).clear();
            x0(r3);
            return;
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.e.a
        public final void u4(BaseAtBean r3) {
            Map<String, BaseAtBean> r4 = this.a.c.h(r3);
            this.a.b.D4(r4, true);
            AtPresenter r5 = this.a;
            r5.b.G8(r5.c.d);
            AtPresenter r6 = this.a;
            r6.b.S3(r6.c.e);
        }

        public final void x0(String r7) {
            StringBuilder r0 = new StringBuilder("start search, searchKey length: ");
            if (r7 != null) goto L5;
            int r2 = 0;
        L6:
            r0.append(r2);
            Log.i("AtPresenter", r0.toString());
            arb.a.b.d0(true);
            IGetDataCallback<Boolean> r1 = new AnonymousClass4(this);
            AtPresenter r3 = this.a;
            r3.i = 0;
            r3.j = 0;
            r3.e = r7;
            r3.f = com.ss.android.lark.sdk.a.a();
            Log.d("AtPresenter", "searchKey: " + r3.e + " requestID: " + r3.f);
            SearchConsistencyReporter.INSTANCE.beginReport(this.a.f, 0);
            IGetDataCallback<List<BaseAtBean>> r4 = new AnonymousClass5(this);
            int r5 = com.ss.android.lark.mention.base.a.a;
            if (FeatureGatingModule.getFeatureGatingService().isEnable("im.mention.display_department") == false) goto L9;
            c(r7, r1, r4);
            b(r7, r1, r4);
            return;
        L9:
            c(r7, r1, null);
            b(r7, r1, null);
            return;
        L5:
            r2 = r7.length();
            goto L6
        }

        public final void b(final String r4, final IGetDataCallback<Boolean> r5, final IGetDataCallback<List<BaseAtBean>> r6) {
            Log.i("AtPresenter", "start localSearch, requestID: " + this.a.f);
            IGetDataCallback<ccb.d> r0 = new AnonymousClass6(this, r5, r4, r6);
            if (NetworkUtils.isNetworkAvailableFast(UIHelper.getContext()) == false) goto L5;
            int r7 = AudioViewModel.ASR_SESSION_IDLE;
        L6:
            ((d) this.a.getModel()).z1(r4, this.a.f, new UIDelayGetDataCallback(r0, r7));
            return;
        L5:
            r7 = 300;
            goto L6
        }

        public final void c(final String r3, final IGetDataCallback<Boolean> r4, final IGetDataCallback<List<BaseAtBean>> r5) {
            Log.i("AtPresenter", "start netSearch, requestID: " + this.a.f);
            ((d) this.a.getModel()).N2(r3, this.a.f, new UIGetDataCallback(new AnonymousClass7(this, r4, r3, r5)));
        }
    }

    public class a implements d.a {
        public final /* synthetic */ AtPresenter a;

        public a(AtPresenter r1) {
            this.a = r1;
        }
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new ViewDelegate(this);
    }

    public final void create() {
        super.create();
        Log.i("AtPresenter", "AtPresenter create, start loadRecommendData");
        f.b().i("loadRecommendData");
        ((d) getModel()).U7(new AnonymousClass1(this));
    }

    public final void destroy() {
        super.destroy();
        this.b = null;
        this.c = null;
    }

    public static List H8(AtPresenter r4, ccb.d r5) {
        r4.getClass();
        List r0 = r5.b;
        List r1 = r5.c;
        List r6 = r5.g;
        ArrayList r2 = new ArrayList();
        r2.addAll(J8(r0, CollectionUtils.isNotEmpty(r1), r6));
        if (CollectionUtils.isEmpty(r1) == false) goto L6;
        return brb.a.a(r2);
    L6:
        if (((d) r4.getModel()).T0() == false) goto L8;
        r2.add(new LabelAtBean(UIHelper.getString(2131890339), UIHelper.getString(2131890857)));
    L9:
        Iterator r7 = ((ArrayList) r1).iterator();
    L11:
        if (r7.hasNext() == false) goto L14;
        SearchBean r3 = new SearchBean(com.ss.android.lark.mention.base.impl.atselector.bean.b.a((ChatChatter) r7.next()));
        r3.setOutChatUser(true);
        r2.add(r3);
        goto L11
    L14:
        return brb.a.a(r2);
    L8:
        r2.add(new LabelAtBean(UIHelper.getString(2131890339), UIHelper.getString(2131890340)));
        goto L9
    }

    public AtPresenter(AtSelectInitData r2, AtView r3, int r4) {
        this.e = "";
        this.f = "";
        this.g = "";
        this.i = 0;
        this.j = 0;
        this.b = r3;
        r3.i = new ViewDelegate(this);
        this.d = r4;
        ChatAtModel r5 = new ChatAtModel(r2);
        this.c = r5;
        r5.b = new a(this);
        this.h = r2.getConfigJson();
        this.a = r2;
        setModel(this.c);
        setView(this.b);
    }

    public static void I8(AtPresenter r1, List r2, Map r3) {
        r1.getClass();
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        BaseAtBean r5 = (BaseAtBean) r4.next();
        r5.setSelected(r3.containsKey(r5.getId()));
        goto L4
    }

    public static List J8(List r3, boolean r4, List r5) {
        ArrayList r0 = new ArrayList();
        if (CollectionUtils.isEmpty(r3) == true) goto L5;
    L9:
        r0.add(new LabelAtBean(UIHelper.getString(2131890337)));
        if (CollectionUtils.isEmpty(r3) == true) goto L21;
        Iterator r6 = ((ArrayList) r3).iterator();
    L13:
        if (r6.hasNext() == false) goto L21;
        ChatChatter r7 = (ChatChatter) r6.next();
        if (com.ss.android.lark.mention.base.a.a() == false) goto L19;
        if (r7.getChatter().isDimission() == true) goto L13;
    L19:
        r0.add(new SearchBean(com.ss.android.lark.mention.base.impl.atselector.bean.b.a(r7)));
    L21:
        if (CollectionUtils.isEmpty(r5) == true) goto L26;
        StringBuilder r8 = new StringBuilder("user group in search size is ");
        ArrayList r9 = (ArrayList) r5;
        r8.append(r9.size());
        Log.i("AtPresenter", r8.toString());
        Iterator r10 = r9.iterator();
    L24:
        if (r10.hasNext() == false) goto L27;
        r0.add(new UserGroupBean((UserGroupEntity) r10.next()));
    L27:
        return r0;
    L26:
        Log.i("AtPresenter", "user group in search is empty");
        goto L27
    L5:
        if (CollectionUtils.isEmpty(r5) == false) goto L9;
        if (r4 == false) goto L8;
        r0.add(new LabelAtBean(UIHelper.getString(2131890337)));
        r0.add(MentionUtils.b());
    L8:
        return r0;
    }
}
