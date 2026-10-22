package com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor;

import android.content.Context;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.config.ji1;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.UnionLiveInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.l;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001!B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R-\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00050\u00190\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/unionlive/anchor/AnchorUnionLiveDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/room/c;", "Landroid/content/Context;", "context", "", "schema", "", "openSchema", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "reqAnchorUnionLiveAccess", "onAnchorClickUnion", "Lcom/bytedance/live/datacontext/j;", "", "enable$delegate", "Lcom/bytedance/live/datacontext/p;", "getEnable", "()Lcom/bytedance/live/datacontext/j;", "enable", "Lcom/bytedance/live/datacontext/m;", "authorized$delegate", "getAuthorized", "()Lcom/bytedance/live/datacontext/m;", "authorized", "", "", "schemaMap$delegate", "getSchemaMap", "schemaMap", "<init>", "()V", "Companion", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorUnionLiveDataContext extends DataContext implements com.bytedance.android.live.room.c {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final int SCHEMA_KEY_INVITE_GUEST = 2;
    public static final int SCHEMA_KEY_MANAGE_GUEST = 3;
    public static final int SCHEMA_KEY_NO_AUTHORITY = 1;
    private final p authorized$delegate;
    private final p enable$delegate;
    private final p schemaMap$delegate;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnchorUnionLiveDataContext a;
        public final /* synthetic */ UnionLiveInfo b;
        public final /* synthetic */ Context c;

        public b(AnchorUnionLiveDataContext r1, UnionLiveInfo r2, Context r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            Response r6 = (Response) r5;
            this.a.m442getAuthorized().setValue(Boolean.valueOf(((com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor.a) ((BaseResponse) r6).data).a()));
            this.a.getSchemaMap().d(((com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor.a) ((BaseResponse) r6).data).c());
            int r0 = com.bytedance.android.livesdk.chatroom.widget.unionlive.d.a;
            com.bytedance.android.livesdk.chatroom.widget.unionlive.d.a("reqAnchorUnionLiveAccess success when click hasAccess = " + ((com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor.a) ((BaseResponse) r6).data).b() + " authorized = " + ((com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor.a) ((BaseResponse) r6).data).a());
            String r1 = null;
            if (((Boolean) this.a.m442getAuthorized().getValue()).booleanValue() == false) goto L19;
            UnionLiveInfo r7 = this.b;
            if (r7 == null) goto L15;
            List r8 = r7.guestAnchors;
            if (r8 == null) goto L15;
            if ((!r8.isEmpty()) != true) goto L15;
            AnchorUnionLiveDataContext r9 = this.a;
            Context r2 = this.c;
            Map r3 = (Map) r9.getSchemaMap().getValue();
            if (r3 == null) goto L14;
            r1 = (String) r3.get(3);
        L14:
            AnchorUnionLiveDataContext.access$openSchema(r9, r2, r1);
            return;
        L15:
            AnchorUnionLiveDataContext r10 = this.a;
            Context r4 = this.c;
            Map r11 = (Map) r10.getSchemaMap().getValue();
            if (r11 == null) goto L18;
            r1 = (String) r11.get(2);
        L18:
            AnchorUnionLiveDataContext.access$openSchema(r10, r4, r1);
            return;
        L19:
            AnchorUnionLiveDataContext r12 = this.a;
            Context r13 = this.c;
            Map r14 = (Map) r12.getSchemaMap().getValue();
            if (r14 == null) goto L22;
            r1 = (String) r14.get(1);
        L22:
            AnchorUnionLiveDataContext.access$openSchema(r12, r13, r1);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            int r0 = com.bytedance.android.livesdk.chatroom.widget.unionlive.d.a;
            com.bytedance.android.livesdk.chatroom.widget.unionlive.d.a("reqAnchorUnionLiveAccess failed click error = " + ((Throwable) r3).getMessage());
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ AnchorUnionLiveDataContext a;

        public d(AnchorUnionLiveDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Response r4 = (Response) r3;
            this.a.getEnable().d(Boolean.valueOf(((com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor.a) ((BaseResponse) r4).data).b()));
            this.a.m442getAuthorized().setValue(Boolean.valueOf(((com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor.a) ((BaseResponse) r4).data).a()));
            this.a.getSchemaMap().d(((com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor.a) ((BaseResponse) r4).data).c());
            int r0 = com.bytedance.android.livesdk.chatroom.widget.unionlive.d.a;
            com.bytedance.android.livesdk.chatroom.widget.unionlive.d.a("reqAnchorUnionLiveAccess success when room create hasAccess = " + ((com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor.a) ((BaseResponse) r4).data).b() + " authorized = " + ((com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor.a) ((BaseResponse) r4).data).a());
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            int r0 = com.bytedance.android.livesdk.chatroom.widget.unionlive.d.a;
            com.bytedance.android.livesdk.chatroom.widget.unionlive.d.a("reqAnchorUnionLiveAccess failed when room create error = " + ((Throwable) r3).getMessage());
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AnchorUnionLiveDataContext.class, "enable", "getEnable()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorUnionLiveDataContext.class, "authorized", "getAuthorized()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorUnionLiveDataContext.class, "schemaMap", "getSchemaMap()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    /* JADX INFO: renamed from: getAuthorized, reason: collision with other method in class */
    public m<Boolean> m442getAuthorized() {
        return (m) this.authorized$delegate.a(this, $$delegatedProperties[1]);
    }

    public j<Boolean> getEnable() {
        return (j) this.enable$delegate.a(this, $$delegatedProperties[0]);
    }

    public final j<Map<Integer, String>> getSchemaMap() {
        return (j) this.schemaMap$delegate.a(this, $$delegatedProperties[2]);
    }

    public AnchorUnionLiveDataContext() {
        this.enable$delegate = ConstantKt.c(this);
        this.authorized$delegate = q.d(this, Boolean.FALSE);
        this.schemaMap$delegate = ConstantKt.c(this);
    }

    public /* bridge */ /* synthetic */ l getAuthorized() {
        return m442getAuthorized();
    }

    public final void reqAnchorUnionLiveAccess(DataCenter r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (getEnable().hasValue() == false) goto L7;
        return;
    L7:
        Room r0 = z.o(r6);
        IUnionLiveApi.a.getClass();
        ((ObservableSubscribeProxy) ((IUnionLiveApi) com.bytedance.android.live.network.c.b().e(IUnionLiveApi.class)).getUnionLiveAccess(r0.getOwnerUserIdString(), r0.id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r6.lifecycleOwner))).subscribe(new d(this), e.a);
    }

    private final void openSchema(Context r2, String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        k.n(ILiveActionHandler.class).handle(r2, r3);
    }

    public void onAnchorClickUnion(Context r7, DataCenter r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (r8 != null) goto L5;
        return;
    L5:
        Room r0 = z.o(r8);
        UnionLiveInfo r1 = r0.unionLiveInfo;
        if (r1 == null) goto L12;
        if (r1.isOgcUnion() != true) goto L12;
        ILiveActionHandler r9 = k.n(ILiveActionHandler.class);
        int r2 = com.bytedance.android.live.room.utils.c.a;
        r9.handle(r7, ji1.a.getValue());
        return;
    L12:
        if (((Boolean) m442getAuthorized().getValue()).booleanValue() == true) goto L14;
    L30:
        IUnionLiveApi.a.getClass();
        ((ObservableSubscribeProxy) ((IUnionLiveApi) com.bytedance.android.live.network.c.b().e(IUnionLiveApi.class)).getUnionLiveAccess(r0.getOwnerUserIdString(), r0.id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r8.lifecycleOwner))).subscribe(new b(this, r1, r7), c.a);
        return;
    L14:
        if (getSchemaMap().hasValue() == false) goto L30;
        String r10 = null;
        if (r1 == null) goto L26;
        List r3 = r1.guestAnchors;
        if (r3 == null) goto L26;
        if ((!r3.isEmpty()) != true) goto L26;
        Map r4 = (Map) getSchemaMap().getValue();
        if (r4 == null) goto L25;
        r10 = (String) r4.get(3);
    L25:
        openSchema(r7, r10);
        return;
    L26:
        Map r5 = (Map) getSchemaMap().getValue();
        if (r5 == null) goto L29;
        r10 = (String) r5.get(2);
    L29:
        openSchema(r7, r10);
    }

    public static final /* synthetic */ void access$openSchema(AnchorUnionLiveDataContext r0, Context r1, String r2) {
        r0.openSchema(r1, r2);
    }
}
