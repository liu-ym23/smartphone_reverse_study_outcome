package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.open.api.GetBootConfigResponse.Data")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0003\u001d\u0005\u0018B\u0007¢\u0006\u0004\b*\u0010+R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/a;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/network/a$b;", "crypt", "Lcom/bytedance/android/live/broadcastgame/opengame/network/a$b;", "b", "()Lcom/bytedance/android/live/broadcastgame/opengame/network/a$b;", "setCrypt", "(Lcom/bytedance/android/live/broadcastgame/opengame/network/a$b;)V", "", "Lcom/bytedance/android/live/broadcastgame/opengame/network/a$a;", "methodList", "Ljava/util/List;", "g", "()Ljava/util/List;", "setMethodList", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/broadcastgame/opengame/network/a$c;", "domainAllowList", "d", "setDomainAllowList", "", "disableInteractIm", "Z", "c", "()Z", "setDisableInteractIm", "(Z)V", "blockConsumeList", "a", "setBlockConsumeList", "", "liveSceneList", "f", "setLiveSceneList", "", "gameCategory", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setGameCategory", "(Ljava/lang/String;)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements vh7.h {

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
    protected List<C0064a> methodList;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.network.a$a, reason: collision with other inner class name */
    @ProtoMessage("webcast.open.api.GetBootConfigResponse.Data.Ability")
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/a$a;", "", "", "name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "maxTimes", "I", "b", "()I", "setMaxTimes", "(I)V", "unitTime", "d", "setUnitTime", "", "", "authInfo", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "setAuthInfo", "(Ljava/util/Map;)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0064a implements vh7.h {

        @SerializedName("auth_info")
        protected Map<String, Long> authInfo;

        @SerializedName("max_times")
        protected int maxTimes;

        @SerializedName("name")
        protected String name;

        @SerializedName("unit_time")
        protected int unitTime;

        public C0064a() {
            this.name = "";
        }

        public final Map<String, Long> a() {
            return this.authInfo;
        }

        public final int b() {
            return this.maxTimes;
        }

        public final String c() {
            return this.name;
        }

        public final int d() {
            return this.unitTime;
        }

        public C0064a(am3.g r11) {
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/a$b;", "", "", "key", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements vh7.h {

        @SerializedName("key")
        protected String key;

        public b() {
            this.key = "";
        }

        public final String a() {
            return this.key;
        }

        public b(am3.g r5) {
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/a$c;", "", "", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "kind", "J", "a", "()J", "setKind", "(J)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c implements vh7.h {

        @SerializedName("kind")
        protected long kind;

        @SerializedName("domain")
        protected String name;

        public c() {
            this.name = "";
            this.kind = 1;
        }

        public final long a() {
            return this.kind;
        }

        public final String b() {
            return this.name;
        }

        public c(am3.g r7) {
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

    public final boolean a() {
        return this.blockConsumeList;
    }

    public final b b() {
        return this.crypt;
    }

    public final boolean c() {
        return this.disableInteractIm;
    }

    public final List<c> d() {
        return this.domainAllowList;
    }

    public final String e() {
        return this.gameCategory;
    }

    public final List<Integer> f() {
        return this.liveSceneList;
    }

    public final List<C0064a> g() {
        return this.methodList;
    }

    public a(am3.g r5) {
        this.methodList = new ArrayList();
        this.domainAllowList = new ArrayList();
        this.liveSceneList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        switch(r2) {
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.gameCategory = am3.h.c(r5);
        goto L3
    L8:
        List r3 = this.liveSceneList;
        vh7.h r4 = Integer.valueOf(r5.i());
    L13:
        r3.add(r4);
        goto L3
    L9:
        this.blockConsumeList = am3.h.a(r5);
        goto L3
    L10:
        this.disableInteractIm = am3.h.a(r5);
        goto L3
    L11:
        r3 = this.domainAllowList;
        r4 = new c(r5);
        goto L13
    L12:
        r3 = this.methodList;
        r4 = new C0064a(r5);
        goto L13
    L14:
        this.crypt = new b(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }
}
