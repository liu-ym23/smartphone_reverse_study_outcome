package com.bytedance.android.livesdk.interactivity.publicscreen.widget;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.chatroom.ui.SmoothLinearLayoutManager;
import com.bytedance.android.livesdk.chatroom.widget.LiveMessageRecyclerView;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.i5;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.GiftMessageDecoupleUtil;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.IRoomMessageExtra;
import com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r52.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003\u000e\u000f\u0010J\b\u0010\u0005\u001a\u00020\u0004H\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/widget/FloatTextMessageView;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Ln42/a;", "getStyle", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "g", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "dataCenter", "a", "b", "c", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FloatTextMessageView extends FrameLayout implements Observer<KVData> {
    public static final /* synthetic */ int j = 0;
    public final b a;
    public final SmoothLinearLayoutManager b;
    public Disposable c;
    public final Boolean d;
    public final int e;
    public final LimitedSizeHashMap<Long, Object> f;
    public DataCenter g;
    public final boolean h;
    public final Function1<List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>>, Unit> i;

    public static final class a {
    }

    public static final class b extends RecyclerView.Adapter<c> {
        public final LayoutInflater a;
        public final com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> b;
        public final Context c;
        public final List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> d;

        public final int getItemCount() {
            return this.d.size();
        }

        public final Context getContext() {
            return this.c;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
            c r8 = (c) r6;
            Intrinsics.checkNotNullParameter(r8, "holder");
            com.bytedance.android.livesdk.interactivity.api.entity.f r9 = (com.bytedance.android.livesdk.interactivity.api.entity.f) ListProtector.get(this.d, r7);
            com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r0 = this.b;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r9, "message");
            IPublicScreenService r2 = (IPublicScreenService) jc1.k.f(IPublicScreenService.class);
            if (r0 == null) goto L6;
            if (r2 == null) goto L6;
            r2.renderLiveMessageWithPublicScreenProcessor(r9.b, r8.a, r0);
            return;
        L6:
            Spannable r1 = r9.m();
            if (r1 != null) goto L9;
        L41:
            r8.a.setVisibility(8);
            return;
        L9:
            if (StringsKt.trim(r1).length() <= 0) goto L11;
            boolean r3 = true;
        L12:
            if (r3 == false) goto L41;
            r8.a.setVisibility(0);
            r8.a.setEllipsize(TextUtils.TruncateAt.END);
            NoMoreSpaceTextView r10 = r8.a;
            o7 r11 = r9.b;
            Intrinsics.checkNotNullParameter(r10, "textView");
            Intrinsics.checkNotNullParameter(r1, "spannable");
            Intrinsics.checkNotNullParameter(r11, "message");
            r10.setText(r1);
            if ((r11 instanceof o7) == false) goto L17;
            long r4 = r11.getGiftId();
        L35:
            if (r4 <= 0) goto L45;
            boolean r13 = com.bytedance.android.live.revenue.core.util.h.a;
            h2 r14 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).findLiteGiftById(r4);
            if (r14 == null) goto L46;
            jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r14.getImage(), new com.bytedance.android.livesdk.interactivity.publicscreen.widget.a(r1, r10));
            return;
        L46:
            return;
        L45:
            return;
        L17:
            if ((r11 instanceof kc2.b) == false) goto L20;
            r4 = ((kc2.b) r11).b;
            goto L35
        L20:
            if (GiftMessageDecoupleUtil.a((tlc.d) r11) == true) goto L22;
        L33:
            r4 = -1;
            goto L35
        L22:
            if ((r11 instanceof c4) == true) goto L24;
            r11 = null;
        L24:
            c4 r15 = (c4) r11;
            if (r15 == null) goto L33;
            IRoomMessageExtra r16 = r15.getRoomMessageExtra();
            if (r16 == null) goto L33;
            IRoomMessageGiftExtra r17 = r16.getGiftExtra();
            if (r17 == null) goto L33;
            Long r18 = r17.getGiftId();
            if (r18 == null) goto L33;
            r4 = r18.longValue();
            goto L35
        L11:
            r3 = false;
            goto L12
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return new c(this.a.inflate(2131566265, r4, false));
        }

        public b(Context r2, List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "messages");
            this.c = r2;
            this.d = r3;
            this.a = LayoutInflater.from(r2);
            if (r4 == false) goto L10;
            IPublicScreenService r5 = (IPublicScreenService) jc1.k.f(IPublicScreenService.class);
            if (r5 == null) goto L7;
            com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r6 = r5.createPublicScreenProcessor();
        L8:
            this.b = r6;
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final NoMoreSpaceTextView a;

        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "msgView");
            super(r2);
            this.a = r2.findViewById(2131388367);
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ FloatTextMessageView a;

        public d(FloatTextMessageView r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r4 = (List) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            FloatTextMessageView r0 = this.a;
            int r1 = FloatTextMessageView.j;
            return r0.b(r4);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ FloatTextMessageView a;

        public e(FloatTextMessageView r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            List r6 = (List) r5;
            b r0 = this.a.a;
            if (r0 == null) goto L27;
            List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r1 = r0.d;
            if (r1 == null) goto L29;
            if (r6 != null) goto L10;
            return;
        L10:
            if (r6.isEmpty() == true) goto L31;
            int r2 = r1.size();
            Function1<List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>>, Unit> r3 = this.a.i;
            if (r3 == null) goto L15;
            Unit r4 = (Unit) r3.invoke(r6);
        L15:
            r1.addAll(r6);
            int r7 = r1.size();
            FloatTextMessageView r8 = this.a;
            int r9 = r7 - r8.e;
            if (r9 <= 0) goto L20;
            r1.subList(0, r9).clear();
            b r10 = this.a.a;
            if (r10 == null) goto L23;
            r10.notifyDataSetChanged();
        L23:
            SmoothLinearLayoutManager r11 = this.a.b;
            if (r11 == null) goto L28;
            r11.scrollToPosition(r1.size() - 1);
            return;
        L28:
            return;
        L20:
            b r13 = r8.a;
            if (r13 == null) goto L23;
            r13.notifyItemInserted(r2);
            goto L23
        L31:
            return;
        L29:
            return;
        }
    }

    static {
    }

    public FloatTextMessageView() {
        throw null;
    }

    private final n42.a getStyle() {
        com.bytedance.android.live.core.utils.a0.e(this.g);
        DataCenter r0 = this.g;
        if (r0 == null) goto L5;
        IRoom r1 = com.bytedance.android.live.core.utils.a0.n(r0);
    L7:
        return q92.b.c(r1);
    L5:
        r1 = null;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ALogger.i("FloatTextMessageView", "onDetachedFromWindow");
        super.onDetachedFromWindow();
        DataCenter r0 = this.g;
        if (r0 == null) goto L5;
        r0.put("data_is_in_float_mode", Boolean.FALSE);
    L5:
        DataCenter r1 = this.g;
        if (r1 == null) goto L8;
        r1.removeObserver(this);
    L8:
        Disposable r2 = this.c;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.c = null;
        if (this.d.booleanValue() == false) goto L14;
    L15:
        this.f.clear();
        return;
    L14:
        if (this.h == true) goto L15;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ALogger.i("FloatTextMessageView", "onAttachedToWindow");
        if (this.d.booleanValue() == false) goto L5;
    L6:
        DataCenter r0 = this.g;
        if (r0 == null) goto L9;
        r0.put("data_is_in_float_mode", Boolean.TRUE);
    L9:
        DataCenter r1 = this.g;
        TransTextMessagePresenter r2 = null;
        if (r1 == null) goto L12;
        TransTextMessagePresenter r3 = (TransTextMessagePresenter) r1.get("data_room_text_message_presenter");
    L14:
        if ((r3 instanceof TransTextMessagePresenter) == false) goto L17;
        r2 = r3;
    L17:
        if (r2 == null) goto L19;
        a(r2);
    L19:
        DataCenter r4 = this.g;
        if (r4 == null) goto L24;
        r4.observe("data_room_text_message_presenter", this);
        return;
    L24:
        return;
    L12:
        r3 = null;
        goto L14
    L5:
        if (this.h == true) goto L6;
    }

    public final DataCenter getDataCenter() {
        return this.g;
    }

    public final void a(TransTextMessagePresenter r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        b r0 = this.a;
        if (r0 == null) goto L35;
        List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r1 = r0.d;
        if (r1 == null) goto L36;
        r1.clear();
        r1.addAll(b(r3.f));
        b r2 = this.a;
        if (r2 == null) goto L12;
        r2.notifyDataSetChanged();
    L12:
        SmoothLinearLayoutManager r4 = this.b;
        if (r4 == null) goto L22;
        b r5 = this.a;
        if (r5 == null) goto L19;
        List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r6 = r5.d;
        if (r6 == null) goto L19;
        int r7 = r6.size();
    L20:
        if (r7 <= 0) goto L22;
        r4.scrollToPosition(r7 - 1);
    L19:
        r7 = 0;
    L22:
        Disposable r8 = this.c;
        if (r8 == null) goto L25;
        r8.dispose();
    L25:
        PublishSubject r9 = r3.i();
        if (r9 == null) goto L32;
        Observable r10 = r9.map(new d(this));
        if (r10 == null) goto L32;
        Observable r11 = r10.observeOn(AndroidSchedulers.mainThread());
        if (r11 == null) goto L32;
        Disposable r13 = r11.subscribe(new e(this));
    L33:
        this.c = r13;
        return;
    L32:
        r13 = null;
        goto L33
    L36:
        return;
    }

    public final List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> b(List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r10) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L27;
        Object r1 = r11.next();
        com.bytedance.android.livesdk.interactivity.api.entity.f r2 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r1;
        boolean r4 = false;
        if (this.f.containsKey(Long.valueOf(r2.o())) == true) goto L25;
        this.f.put(Long.valueOf(r2.o()), null);
        String r3 = r2.b.getMessageMethod();
        boolean r5 = Intrinsics.areEqual(r3, "WebcastChatMessage");
        if (Intrinsics.areEqual(r3, "WebcastGiftMessage") == false) goto L11;
    L18:
        boolean r6 = true;
    L19:
        boolean r7 = Intrinsics.areEqual(r3, "WebcastRoomMessage");
        boolean r8 = Intrinsics.areEqual(r3, "WebcastMemberMessage");
        if (r5 == true) goto L24;
        if (r6 == true) goto L24;
        if (r8 == true) goto L24;
        if (r7 == false) goto L25;
    L24:
        r4 = true;
        goto L25
    L11:
        if (Intrinsics.areEqual(r3, "WebcastDoodleGiftMessage") == true) goto L18;
        if (Intrinsics.areEqual(r3, "GiftGroupMessage") == true) goto L18;
        if (GiftMessageDecoupleUtil.a(r2.b) == true) goto L18;
        r6 = false;
    L25:
        if (r4 == false) goto L4;
        r0.add(r1);
        goto L4
    L27:
        return r0;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L13;
        String r0 = r5.getKey();
        if (r0.hashCode() == 1633140397) goto L9;
        return;
    L9:
        if (r0.equals("data_room_text_message_presenter") == false) goto L12;
        a((TransTextMessagePresenter) r5.getData());
        return;
    L12:
        return;
    }

    public final void setDataCenter(DataCenter r1) {
        this.g = r1;
    }

    public FloatTextMessageView(DataCenter r6, Context r7, boolean r8, boolean r9, Function1 r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        TransTextMessagePresenter r0 = null;
        super(r7, null, 0);
        this.g = r6;
        this.h = r8;
        this.i = r10;
        Boolean r11 = (Boolean) i5.a.getValue();
        this.d = r11;
        int r13 = ((com.bytedance.android.livesdk.interactivity.api.settings.config.q) p0.a.getValue()).e();
        this.e = r13;
        this.f = new LimitedSizeHashMap(r13 * 2);
        FrameLayout.inflate(r7, 2131567393, this);
        LiveMessageRecyclerView r14 = findViewById(2131380030);
        SmoothLinearLayoutManager r2 = new SmoothLinearLayoutManager(r7);
        this.b = r2;
        b r3 = new b(r7, new ArrayList(), r9);
        this.a = r3;
        if (r14 == null) goto L6;
        r14.setLayoutManager(r2);
        r14.setAdapter(r3);
        r14.addItemDecoration(new SpaceItemDecoration(1, (int) UIUtils.dip2Px(r7, 3), false));
    L6:
        if (r11.booleanValue() == true) goto L25;
        if (r8 == true) goto L26;
        DataCenter r15 = this.g;
        if (r15 == null) goto L11;
        r15.put("data_is_in_float_mode", Boolean.TRUE);
    L11:
        DataCenter r16 = this.g;
        if (r16 == null) goto L14;
        TransTextMessagePresenter r17 = (TransTextMessagePresenter) r16.get("data_room_text_message_presenter");
    L16:
        if ((r17 instanceof TransTextMessagePresenter) == false) goto L19;
        r0 = r17;
    L19:
        if (r0 == null) goto L21;
        a(r0);
    L21:
        DataCenter r18 = this.g;
        if (r18 == null) goto L27;
        r18.observe("data_room_text_message_presenter", this);
        return;
    L27:
        return;
    L14:
        r17 = null;
        goto L16
    L26:
        return;
    }
}
