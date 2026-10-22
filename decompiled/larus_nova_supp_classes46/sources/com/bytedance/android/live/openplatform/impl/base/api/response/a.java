package com.bytedance.android.live.openplatform.impl.base.api.response;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.open.api.GetBootConfigResponse.Data")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0003\r,/B\u0007¢\u0006\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001b¨\u00060"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/api/response/a;", "", "Lcom/bytedance/android/live/openplatform/impl/base/api/response/a$b;", "crypt", "Lcom/bytedance/android/live/openplatform/impl/base/api/response/a$b;", "getCrypt", "()Lcom/bytedance/android/live/openplatform/impl/base/api/response/a$b;", "setCrypt", "(Lcom/bytedance/android/live/openplatform/impl/base/api/response/a$b;)V", "", "Lcom/bytedance/android/live/openplatform/impl/base/api/response/a$a;", "methodList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setMethodList", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/openplatform/impl/base/api/response/a$c;", "domainAllowList", "getDomainAllowList", "setDomainAllowList", "", "disableInteractIm", "Z", "getDisableInteractIm", "()Z", "setDisableInteractIm", "(Z)V", "blockConsumeList", "getBlockConsumeList", "setBlockConsumeList", "", "liveSceneList", "getLiveSceneList", "setLiveSceneList", "", "gameCategory", "Ljava/lang/String;", "getGameCategory", "()Ljava/lang/String;", "setGameCategory", "(Ljava/lang/String;)V", "shelvesEnable", "getShelvesEnable", "b", "<init>", "()V", "c", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("block_consume_list")
    protected boolean blockConsumeList;

    @SerializedName("room_crypt")
    protected b crypt;

    @SerializedName("disable_interact_im")
    protected boolean disableInteractIm;

    @SerializedName("domain_allow_list")
    protected List<c> domainAllowList;

    @SerializedName("game_category")
    protected String gameCategory;

    @SerializedName("live_scene")
    protected List<Integer> liveSceneList;

    @SerializedName("ability_list")
    protected List<C0140a> methodList;

    @SerializedName("shelves_enable")
    protected boolean shelvesEnable;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.base.api.response.a$a, reason: collision with other inner class name */
    @ProtoMessage("webcast.open.api.GetBootConfigResponse.Data.Ability")
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/api/response/a$a;", "", "", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "maxTimes", "I", "a", "()I", "setMaxTimes", "(I)V", "unitTime", "c", "setUnitTime", "", "", "authInfo", "Ljava/util/Map;", "getAuthInfo", "()Ljava/util/Map;", "setAuthInfo", "(Ljava/util/Map;)V", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0140a implements h {

        @SerializedName("auth_info")
        protected Map<String, Long> authInfo;

        @SerializedName("max_times")
        protected int maxTimes;

        @SerializedName("name")
        protected String name;

        @SerializedName("unit_time")
        protected int unitTime;

        public C0140a() {
            this.name = "";
        }

        public final int a() {
            return this.maxTimes;
        }

        public final String b() {
            return this.name;
        }

        public final int c() {
            return this.unitTime;
        }

        public C0140a(g r11) {
            this.authInfo = new HashMap();
            long r0 = r11.c();
        L3:
            int r2 = r11.f();
            if (r2 == (-1)) goto L33;
            if (r2 != 1) goto L8;
            this.name = am3.h.c(r11);
            goto L3
        L8:
            if (r2 != 2) goto L10;
            this.maxTimes = (int) r11.j();
            goto L3
        L10:
            if (r2 != 3) goto L12;
            this.unitTime = (int) r11.j();
            goto L3
        L12:
            if (r2 != 4) goto L13;
            long r6 = r11.c();
            String r3 = null;
            Long r8 = null;
        L15:
            int r9 = r11.f();
            if (r9 == (-1)) goto L22;
            if (r9 != 1) goto L18;
            r3 = am3.h.c(r11);
            goto L15
        L18:
            if (r9 != 2) goto L19;
            r8 = Long.valueOf(r11.j());
            goto L15
        L19:
            am3.h.e(r11);
            goto L15
        L22:
            r11.d(r6);
            Map<String, Long> r4 = this.authInfo;
            if (r3 == null) goto L29;
            if (r8 == null) goto L27;
            r4.put(r3, r8);
            goto L3
        L27:
            throw new IllegalStateException("Value must not be null");
        L29:
            throw new IllegalStateException("Key must not be null");
        L13:
            am3.h.e(r11);
            goto L3
        L33:
            r11.d(r0);
            if (this.name != null) goto L63;
            this.name = "";
            return;
        }
    }

    @ProtoMessage("webcast.open.api.GetBootConfigResponse.Data.RoomCrypt")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/api/response/a$b;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements h {

        @SerializedName("key")
        protected String key;

        public b() {
            this.key = "";
        }

        public b(g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            this.key = am3.h.c(r5);
            goto L3
        L7:
            am3.h.e(r5);
            goto L3
        L9:
            r5.d(r0);
            if (this.key != null) goto L19;
            this.key = "";
            return;
        }
    }

    @ProtoMessage("webcast.open.api.GetBootConfigResponse.Data.Domain")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/api/response/a$c;", "", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "kind", "J", "getKind", "()J", "setKind", "(J)V", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c implements h {

        @SerializedName("kind")
        protected long kind;

        @SerializedName("domain")
        protected String name;

        public c() {
            this.name = "";
            this.kind = 1;
        }

        public c(g r7) {
            long r0 = r7.c();
            boolean r2 = false;
        L3:
            int r3 = r7.f();
            if (r3 == (-1)) goto L11;
            if (r3 != 1) goto L7;
            this.name = am3.h.c(r7);
            goto L3
        L7:
            if (r3 != 2) goto L8;
            this.kind = r7.j();
            r2 = r2 | true;
            goto L3
        L8:
            am3.h.e(r7);
            goto L3
        L11:
            r7.d(r0);
            if (this.name != null) goto L15;
            this.name = "";
        L15:
            if ((r2 & true) == true) goto L27;
            this.kind = 1;
            return;
        }
    }

    public a() {
    }

    public final void b() {
        this.shelvesEnable = true;
    }

    public final List<C0140a> a() {
        return this.methodList;
    }

    public a(g r5) {
        this.methodList = new ArrayList();
        this.domainAllowList = new ArrayList();
        this.liveSceneList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L16;
        switch(r2) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.shelvesEnable = am3.h.a(r5);
        goto L3
    L8:
        this.gameCategory = am3.h.c(r5);
        goto L3
    L9:
        List r3 = this.liveSceneList;
        h r4 = Integer.valueOf(r5.i());
    L14:
        r3.add(r4);
        goto L3
    L10:
        this.blockConsumeList = am3.h.a(r5);
        goto L3
    L11:
        this.disableInteractIm = am3.h.a(r5);
        goto L3
    L12:
        r3 = this.domainAllowList;
        r4 = new c(r5);
        goto L14
    L13:
        r3 = this.methodList;
        r4 = new C0140a(r5);
        goto L14
    L15:
        this.crypt = new b(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L16:
        r5.d(r0);
    }
}
