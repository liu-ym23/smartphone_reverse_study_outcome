package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.util.GiftToRechargeParamsKey;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.configmodel.m2;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.k3;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.y1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.r3;
import com.bytedance.android.livesdk.gift.platform.core.utils.e0;
import com.bytedance.android.livesdk.log.model.WishComboDataLog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomEx;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class SendGiftMethod extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {
    public WishComboDataLog a;
    public final com.bytedance.android.scope.j b;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\bg\u0010hR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR$\u0010$\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR$\u00101\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0012\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u0010\u0016R$\u00104\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0012\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R\"\u00107\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0012\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR$\u0010D\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR*\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Q\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010)\u001a\u0004\bR\u0010+\"\u0004\bS\u0010-R\"\u0010T\u001a\u00020\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010Z\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010)\u001a\u0004\b[\u0010+\"\u0004\b\\\u0010-R0\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010]8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR0\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010]8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010_\u001a\u0004\be\u0010a\"\u0004\bf\u0010c¨\u0006i"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/SendGiftMethod$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "giftId", "J", "g", "()J", "setGiftId", "(J)V", BuildConfig.FLAVOR, "giftCount", "I", "f", "()I", "setGiftCount", "(I)V", BuildConfig.FLAVOR, "giftType", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "v", "(Ljava/lang/String;)V", "allowCharge", "a", "setAllowCharge", "Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/SendGiftMethod$a$a;", "args", "Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/SendGiftMethod$a$a;", "b", "()Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/SendGiftMethod$a$a;", "setArgs", "(Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/SendGiftMethod$a$a;)V", "buffLevel", "c", "setBuffLevel", "groupId", "j", "setGroupId", BuildConfig.FLAVOR, "isEndCombo", "Z", "u", "()Z", "setEndCombo", "(Z)V", "sendType", "n", "setSendType", "giftSource", "h", "setGiftSource", "source", "o", "setSource", "toUserId", "q", "setToUserId", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "toUserInfo", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "s", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setToUserInfo", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "sendScene", "m", "setSendScene", "receiverType", "Ljava/lang/Integer;", "l", "()Ljava/lang/Integer;", "setReceiverType", "(Ljava/lang/Integer;)V", BuildConfig.FLAVOR, "toUserIdList", "Ljava/util/List;", "r", "()Ljava/util/List;", "setToUserIdList", "(Ljava/util/List;)V", "panelLocateRemember", "k", "setPanelLocateRemember", "disableBigGiftCombo", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "setDisableBigGiftCombo", "(Ljava/lang/Object;)V", "getResultWhenGiftTransactionFinish", "e", "setGetResultWhenGiftTransactionFinish", BuildConfig.FLAVOR, "trackExtra", "Ljava/util/Map;", "t", "()Ljava/util/Map;", "setTrackExtra", "(Ljava/util/Map;)V", "tagsExtra", "p", "setTagsExtra", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("allow_charge")
        private int allowCharge;

        @SerializedName("args")
        private C0058a args;

        @SerializedName("gift_buff_level")
        private int buffLevel;

        @SerializedName("disable_big_gift_combo")
        private Object disableBigGiftCombo;

        @SerializedName("get_result_when_gift_transaction_finish")
        private boolean getResultWhenGiftTransactionFinish;

        @SerializedName("gift_count")
        private int giftCount;

        @SerializedName("gift_id")
        private long giftId;

        @SerializedName("gift_source")
        private String giftSource;

        @SerializedName("gift_type")
        private String giftType;

        @SerializedName("group_id")
        private String groupId;

        @SerializedName("end_combo")
        private boolean isEndCombo;

        @SerializedName("panel_locate_remember")
        private boolean panelLocateRemember;

        @SerializedName("receiver_type")
        private Integer receiverType;

        @SerializedName("send_scene")
        private int sendScene;

        @SerializedName("send_type")
        private int sendType;

        @SerializedName("source")
        private String source;

        @SerializedName("tags_extra")
        private Map<String, String> tagsExtra;

        @SerializedName("to_user_id")
        private String toUserId;

        @SerializedName("to_user_ids")
        private List<String> toUserIdList;

        @SerializedName("to_user_info")
        private IBaseUser toUserInfo;

        @SerializedName("track_extra")
        private Map<String, String> trackExtra;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods.SendGiftMethod$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b7\u00108R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R6\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R6\u0010$\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020#\u0018\u0001`\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR$\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR0\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00104\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\b¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/SendGiftMethod$a$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "requestPage", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setRequestPage", "(Ljava/lang/String;)V", "extra", "d", "setExtra", BuildConfig.FLAVOR, "totalPrice", "I", "j", "()I", "setTotalPrice", "(I)V", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdk/gift/model/e3;", "Lkotlin/collections/ArrayList;", "pluginInfo", "Ljava/util/ArrayList;", "e", "()Ljava/util/ArrayList;", "setPluginInfo", "(Ljava/util/ArrayList;)V", BuildConfig.FLAVOR, "configId", "J", "c", "()J", "setConfigId", "(J)V", "Lcom/bytedance/android/livesdk/gift/model/k3;", "seriesGiftInfo", "g", "setSeriesGiftInfo", "seriesName", "h", "setSeriesName", "afterSendSchema", "a", "setAfterSendSchema", BuildConfig.FLAVOR, "toRechargeParams", "Ljava/util/Map;", "i", "()Ljava/util/Map;", "setToRechargeParams", "(Ljava/util/Map;)V", "cardName", "b", "setCardName", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0058a {

            @SerializedName("after_send_schema")
            private String afterSendSchema;

            @SerializedName("toolbar_card_name")
            private String cardName;

            @SerializedName("config_id")
            private long configId;

            @SerializedName("extra")
            private String extra;

            @SerializedName("plugin_info")
            private ArrayList<e3> pluginInfo;

            @SerializedName("request_page")
            private String requestPage;

            @SerializedName("series_gift_list")
            private ArrayList<k3> seriesGiftInfo;

            @SerializedName("series_name")
            private String seriesName;

            @SerializedName("to_recharge_params")
            private Map<String, String> toRechargeParams;

            @SerializedName("total_price")
            private int totalPrice;

            public C0058a() {
                this.pluginInfo = new ArrayList();
            }

            public final String a() {
                return this.afterSendSchema;
            }

            public final String b() {
                return this.cardName;
            }

            public final long c() {
                return this.configId;
            }

            public final String d() {
                return this.extra;
            }

            public final ArrayList<e3> e() {
                return this.pluginInfo;
            }

            public final String f() {
                return this.requestPage;
            }

            public final ArrayList<k3> g() {
                return this.seriesGiftInfo;
            }

            public final String h() {
                return this.seriesName;
            }

            public final Map<String, String> i() {
                return this.toRechargeParams;
            }

            public final int j() {
                return this.totalPrice;
            }
        }

        public a() {
            this.toUserId = BuildConfig.FLAVOR;
            this.disableBigGiftCombo = Boolean.FALSE;
            this.getResultWhenGiftTransactionFinish = true;
        }

        public final int a() {
            return this.allowCharge;
        }

        public final C0058a b() {
            return this.args;
        }

        public final int c() {
            return this.buffLevel;
        }

        public final Object d() {
            return this.disableBigGiftCombo;
        }

        public final boolean e() {
            return this.getResultWhenGiftTransactionFinish;
        }

        public final int f() {
            return this.giftCount;
        }

        public final long g() {
            return this.giftId;
        }

        public final String h() {
            return this.giftSource;
        }

        public final String i() {
            return this.giftType;
        }

        public final String j() {
            return this.groupId;
        }

        public final boolean k() {
            return this.panelLocateRemember;
        }

        public final Integer l() {
            return this.receiverType;
        }

        public final int m() {
            return this.sendScene;
        }

        public final int n() {
            return this.sendType;
        }

        public final String o() {
            return this.source;
        }

        public final Map<String, String> p() {
            return this.tagsExtra;
        }

        public final String q() {
            return this.toUserId;
        }

        public final List<String> r() {
            return this.toUserIdList;
        }

        public final IBaseUser s() {
            return this.toUserInfo;
        }

        public final Map<String, String> t() {
            return this.trackExtra;
        }

        public final boolean u() {
            return this.isEndCombo;
        }

        public final void v(String r1) {
            this.giftType = r1;
        }
    }

    public final void onTerminate() {
        WishComboDataLog r0 = this.a;
        if (r0 == null) goto L6;
        r0.clearMap();
        return;
    }

    public SendGiftMethod(com.bytedance.android.scope.j r1) {
        this.b = r1;
    }

    public static void j(JSONObject r3) {
        d60.b.a(r3, "live_recharge_no_balanace_opt", Integer.valueOf(((Number) v.c.getValue(null, v.a[1])).intValue()));
    }

    public final void invoke(Object r44, CallContext r45) {
        final a r6 = (a) r44;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r45, "context");
        CompositeDisposable r14 = new CompositeDisposable();
        Map<String, com.bytedance.android.livesdk.gift.platform.core.model.t> r7 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.f();
        final long r8 = r6.g();
        final int r21 = r6.f();
        int r1 = r6.a();
        final int r11 = r6.c();
        Ref.IntRef r10 = new Ref.IntRef();
        r10.element = 0;
        Ref.IntRef r13 = new Ref.IntRef();
        r13.element = -1;
        String r3 = r6.q();
        a.C0058a r4 = r6.b();
        if (r4 == null) goto L5;
        final long r16 = r4.c();
    L6:
        final List<String> r23 = r6.r();
        Object r5 = r6.d();
        if ((r5 instanceof Boolean) == false) goto L10;
        boolean r9 = ((Boolean) r5).booleanValue();
    L12:
        final boolean r24 = r9;
    L15:
        if (TextUtils.isEmpty(r6.o()) == true) goto L17;
        String r15 = r6.o();
    L18:
        final String r18 = r15;
        if (r6.b() == null) goto L23;
        a.C0058a r17 = r6.b();
        Intrinsics.checkNotNull(r17);
        if (r17.d() == null) goto L23;
        a.C0058a r19 = r6.b();
        Intrinsics.checkNotNull(r19);
        String r20 = r19.d();
    L25:
        if (r20 == null) goto L47;
        final Ref.IntRef r25 = r13;
        Map<String, com.bytedance.android.livesdk.gift.platform.core.model.t> r26 = r7;
        Ref.IntRef r27 = r10;
        if (StringsKt.contains$default(r20, "order_sing", false, 2, null) != true) goto L48;
        GiftContext r28 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r28 == null) goto L33;
        com.bytedance.live.datacontext.n<Bundle> r29 = r28.getGiftLogExtra();
        if (r29 == null) goto L33;
        Bundle r30 = (Bundle) r29.getValue();
    L34:
        if (r30 != null) goto L40;
        GiftContext r31 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r31 == null) goto L40;
        com.bytedance.live.datacontext.n<Bundle> r33 = r31.getGiftLogExtra();
        if (r33 == null) goto L40;
        r33.setValue(new Bundle());
    L40:
        GiftContext r34 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r34 == null) goto L48;
        com.bytedance.live.datacontext.n<Bundle> r35 = r34.getGiftLogExtra();
        if (r35 == null) goto L48;
        Bundle r36 = (Bundle) r35.getValue();
        if (r36 == null) goto L48;
        r36.putString("gift_show_from", "request_song_list");
        Unit r37 = Unit.INSTANCE;
    L33:
        r30 = null;
    L48:
        GiftContext r38 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r38 == null) goto L53;
        com.bytedance.live.datacontext.n<Bundle> r39 = r38.getGiftLogExtra();
        if (r39 == null) goto L53;
        Bundle r40 = (Bundle) r39.getValue();
    L54:
        if (r40 != null) goto L60;
        GiftContext r41 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r41 == null) goto L60;
        com.bytedance.live.datacontext.n<Bundle> r43 = r41.getGiftLogExtra();
        if (r43 == null) goto L60;
        r43.setValue(new Bundle());
    L60:
        GiftContext r46 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r46 == null) goto L67;
        com.bytedance.live.datacontext.n<Bundle> r47 = r46.getGiftLogExtra();
        if (r47 == null) goto L67;
        Bundle r48 = (Bundle) r47.getValue();
        if (r48 == null) goto L67;
        r48.putString("gift_show_from", "none");
        Unit r2 = Unit.INSTANCE;
    L67:
        this.a = jc1.k.n(IGiftService.class).getWishComboDataMap();
        Ref.ObjectRef r110 = new Ref.ObjectRef();
        r110.element = BuildConfig.FLAVOR;
        if (r6.b() == null) goto L73;
        a.C0058a r49 = r6.b();
        Intrinsics.checkNotNull(r49);
        if (TextUtils.isEmpty(r49.f()) == true) goto L73;
        a.C0058a r50 = r6.b();
        Intrinsics.checkNotNull(r50);
        r110.element = r50.f();
    L76:
        if (r6.i() != null) goto L78;
        r6.v((String) r110.element);
    L78:
        final h2 r210 = jc1.k.n(IGiftService.class).findLiteGiftById(r8);
        if (r6.b() == null) goto L83;
        a.C0058a r51 = r6.b();
        Intrinsics.checkNotNull(r51);
        if (r51.j() <= 0) goto L83;
        a.C0058a r53 = r6.b();
        Intrinsics.checkNotNull(r53);
        int r54 = r53.j() * r21;
        a.C0058a r55 = r6.b();
        Intrinsics.checkNotNull(r55);
        r55.getClass();
        int r56 = r54;
    L115:
        long r111 = jc1.k.n(IRechargeService.class).rechargeCenter().getAvailableDiamonds();
        com.bytedance.android.live.revenue.core.util.j.a r211 = com.bytedance.android.live.revenue.core.util.j.C0;
        final String r212 = r20;
        yz0.k r57 = com.bytedance.android.live.revenue.core.util.f.d(r211.a(), yz0.k.class);
        if (r57 == null) goto L118;
        IRoomEx r58 = r57.getRoom();
    L119:
        final Ref.ObjectRef r59 = new Ref.ObjectRef();
        r59.element = null;
        final Ref.ObjectRef r112 = new Ref.ObjectRef();
        r112.element = null;
        if (r3.length() <= 0) goto L122;
        boolean r310 = true;
    L123:
        if (r310 == false) goto L196;
        com.bytedance.android.live.revenue.core.b r60 = r211.a();
        Ref.ObjectRef r213 = r110;
        yz0.k r61 = com.bytedance.android.live.revenue.core.util.f.d(r60, yz0.k.class);
        if (r61 == null) goto L131;
        IRoom r63 = r61.getRoom();
        if (r63 == null) goto L131;
        IBaseUser r64 = r63.getOwner();
        if (r64 == null) goto L131;
        String r65 = r64.getIdString();
    L132:
        Integer r113 = r6.l();
        CompositeDisposable r311 = r14;
        int r114 = ReceiverType.MicTeamAnchor.getValue();
        if (r113 != null) goto L136;
    L138:
        boolean r115 = false;
    L140:
        if ((!Intrinsics.areEqual(r3, r65)) == false) goto L159;
        if (r115 == true) goto L159;
        com.bytedance.android.scope.j r66 = this.b;
        if (r66 == null) goto L159;
        GiftReceiverRepoService r67 = (GiftReceiverRepoService) com.bytedance.android.scope.m.e.d(r66, GiftReceiverRepoService.class);
        if (r67 == null) goto L159;
        List<IBaseUser> r68 = r67.k().a;
        if (r68 == null) goto L159;
        Iterator<T> r69 = r68.iterator();
    L150:
        if (r69.hasNext() == false) goto L154;
        Object r116 = r69.next();
        if (Intrinsics.areEqual(((IBaseUser) r116).getIdString(), r3) == false) goto L150;
        Object r70 = r116;
    L156:
        if (((IBaseUser) r70) != null) goto L158;
        ToastUtil.a(2131922460, 0);
        k(new ApiException(-7), null);
        SendGiftMethod r117 = this;
    L395:
        return;
    L158:
        Unit r118 = Unit.INSTANCE;
        goto L159
    L154:
        r70 = null;
    L159:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r119 = com.bytedance.android.livesdk.gift.platform.core.utils.s.c();
        if (r119 == null) goto L162;
        IBaseUser r120 = r119.a;
    L163:
        if (r120 != null) goto L165;
    L170:
        yz0.k r121 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r121 == null) goto L182;
        IRoom r122 = r121.getRoom();
        if (r122 == null) goto L182;
        IBaseUser r123 = r122.getOwner();
        if (r123 == null) goto L182;
        if (Intrinsics.areEqual(r123.getIdString(), r3) == true) goto L180;
        r123 = null;
    L180:
        if (r123 == null) goto L182;
        r59.element = r123;
        Unit r124 = Unit.INSTANCE;
    L182:
        com.bytedance.android.scope.j r125 = this.b;
        if (r125 == null) goto L188;
        GiftReceiverRepoService r71 = (GiftReceiverRepoService) com.bytedance.android.scope.m.e.d(r125, GiftReceiverRepoService.class);
        if (r71 == null) goto L188;
        List<IBaseUser> r73 = r71.k().a;
        if (r73 == null) goto L188;
    L189:
        Iterator<IBaseUser> r74 = r73.iterator();
    L191:
        if (r74.hasNext() == false) goto L195;
        IBaseUser r126 = r74.next();
        if (Intrinsics.areEqual(r126.getIdString(), r3) == false) goto L191;
        r59.element = r126;
    L195:
        Unit r75 = Unit.INSTANCE;
    L197:
        IBaseUser r76 = r6.s();
        if (r76 == null) goto L214;
        r59.element = r76;
        py.o r77 = r76.getOwnRoom();
        if (r77 == null) goto L214;
        List r78 = r77.getRoomIdStrList();
        if (r78 == null) goto L214;
        String r79 = (String) CollectionsKt.getOrNull(r78, 0);
        if (r79 == null) goto L214;
        Long r80 = StringsKt.toLongOrNull(r79);
        if (r80 == null) goto L214;
        long r81 = r80.longValue();
        IBaseUser r127 = (IBaseUser) r59.element;
        if (r127 == null) goto L214;
        py.o r128 = r127.getOwnRoom();
        if (r128 == null) goto L214;
        List r129 = r128.getRoomIdList();
        if (r129 == null) goto L214;
        Long r83 = (Long) ListProtector.set(r129, 0, Long.valueOf(r81));
    L214:
        final Ref.ObjectRef r130 = new Ref.ObjectRef();
        r130.element = null;
        final Ref.ObjectRef r131 = new Ref.ObjectRef();
        r131.element = null;
        Integer r84 = r6.l();
        if (r84 == null) goto L241;
        int r85 = r84.intValue();
        ReceiverType.Companion.getClass();
        ReceiverType[] r86 = ReceiverType.values();
        int r132 = r86.length;
        int r87 = 0;
    L217:
        if (r87 >= r132) goto L225;
        ReceiverType r312 = r86[r87];
        ReceiverType[] r313 = r86;
        if (r312.getValue() != r85) goto L221;
        boolean r88 = true;
    L222:
        if (r88 == true) goto L223;
        r87 = r87 + 1;
        r86 = r313;
        goto L217
    L223:
        ReceiverType r89 = r312;
    L226:
        if (r89 != null) goto L228;
        r89 = ReceiverType.Anchor;
    L228:
        r112.element = r89;
        if (r89 != ReceiverType.MicTeamAnchor) goto L239;
        IBaseUser r90 = r6.s();
        if (r90 == null) goto L233;
        Long r91 = Long.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r90));
    L234:
        r130.element = r91;
        IBaseUser r93 = r6.s();
        if (r93 == null) goto L237;
        String r94 = r93.getIdString();
    L238:
        r131.element = r94;
        goto L239
    L237:
        r94 = null;
        goto L238
    L233:
        r91 = null;
    L239:
        Unit r95 = Unit.INSTANCE;
        goto L241
    L221:
        r88 = false;
        goto L222
    L225:
        r89 = null;
    L241:
        final Ref.ObjectRef r133 = new Ref.ObjectRef();
        a.C0058a r96 = r6.b();
        if (r96 == null) goto L244;
        Map<String, String> r97 = r96.i();
    L245:
        r133.element = r97;
        if (r58 == null) goto L354;
        long r98 = r56;
        if (r111 >= r98) goto L354;
        if (r1 != 1) goto L354;
        long r99 = r98 - r111;
        int r100 = ay1.b.u();
        ReadOnlyProperty r101 = com.bytedance.android.livesdk.gift.platform.business.b.I;
        KProperty[] r102 = com.bytedance.android.livesdk.gift.platform.business.b.a;
        if (((m2) r101.getValue(null, r102[33])).b() == true) goto L260;
        if (ay0.c.a() != 0) goto L260;
        if (ay0.c.b() != 0) goto L260;
        if (ay0.c.c() != 0) goto L260;
    L266:
        boolean r103 = false;
    L267:
        if (r103 == true) goto L353;
        int r104 = ((Number) com.bytedance.android.livesdk.gift.platform.business.d.b.getValue(null, com.bytedance.android.livesdk.gift.platform.business.d.a[0])).intValue();
        String r105 = (String) com.bytedance.android.livesdk.gift.platform.business.a.h.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[6]);
        int r106 = e0.a;
        if (r104 == 1) goto L271;
    L273:
        boolean r214 = false;
    L274:
        Map r107 = (Map) r133.element;
        if (r107 == null) goto L278;
        String r108 = (String) r107.get(GiftToRechargeParamsKey.KEY_SEND_GIFT_CHARGE_REASON.getKeyName());
        if (r108 == null) goto L278;
    L279:
        String r134 = r108;
        if (r210 == null) goto L282;
        long r215 = r210.getDiamondCount();
    L283:
        x2 r109 = new x2(r134, r8, r215, r98, r99, r111, r214, (Map) r133.element);
        String r0 = r45.b;
        if (r0 != null) goto L286;
    L288:
        String r216 = null;
    L289:
        r109.s = UriProtector.parse(r216).getPath();
        Unit r135 = Unit.INSTANCE;
        r109.r = "SendGiftMethod";
        xs2.b.a().post(r109);
        long r136 = r58.getRoomId();
        String r137 = r58.getAnchorId();
        if (r137 != null) goto L292;
        r137 = BuildConfig.FLAVOR;
    L292:
        IBaseUser r138 = (IBaseUser) ((Ref.ObjectRef) r5).element;
        if (r138 == null) goto L295;
        long r139 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r138);
    L296:
        ReceiverType r140 = (ReceiverType) r112.element;
        IBaseUser r141 = (IBaseUser) ((Ref.ObjectRef) r5).element;
        String r142 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        if (r140 != null) goto L329;
        yz0.k r143 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r143 == null) goto L301;
        IRoom r217 = r143.getRoom();
    L302:
        if (r141 == null) goto L328;
        String r144 = r141.getIdString();
        if (r217 == null) goto L306;
        String r145 = r217.getAnchorId();
    L308:
        if (Intrinsics.areEqual(r144, r145) == true) goto L328;
        String r146 = r141.getIdString();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r147 = com.bytedance.android.livesdk.gift.platform.core.utils.s.c();
        if (r147 == null) goto L315;
        IBaseUser r148 = r147.a;
        if (r148 == null) goto L315;
        String r149 = r148.getIdString();
    L317:
        if (Intrinsics.areEqual(r146, r149) == false) goto L319;
        r140 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.d();
        goto L329
    L319:
        i12.e r150 = i12.o.b();
        if (r150 == null) goto L322;
        Object r218 = com.bytedance.android.scope.m.e.d(r150, GiftReceiverRepoService.class);
    L323:
        GiftReceiverRepoService r151 = (GiftReceiverRepoService) r218;
        if (r151 == null) goto L327;
        r140 = r151.R(r141);
        if (r140 != null) goto L329;
    L327:
        r140 = ReceiverType.Anchor;
        goto L329
    L322:
        r218 = null;
    L315:
        r149 = null;
        goto L317
    L306:
        r145 = null;
    L328:
        r140 = ReceiverType.Anchor;
        goto L329
    L301:
        r217 = null;
    L329:
        i12.e r152 = i12.o.b();
        if (r152 == null) goto L332;
        Object r219 = com.bytedance.android.scope.m.e.d(r152, r3.class);
    L333:
        r3 r153 = (r3) r219;
        if (r153 == null) goto L336;
        int r154 = r153.f(r140);
    L337:
        boolean r155 = d0.a;
        if (r141 == null) goto L343;
        String r156 = r141.getIdString();
        if (r156 == null) goto L343;
        String r220 = r156;
    L344:
        d0.p(r8, 0, false, r136, 102, "jsb send gift money is not enough", r142, r137, r220, r139, r154);
        if (r141 == null) goto L350;
        String r157 = r141.getIdString();
        if (r157 == null) goto L350;
        String r221 = r157;
    L351:
        d0.q(r8, 0, false, r136, 102, "jsb send gift money is not enough", r142, r137, r221, r139, r154);
        r117 = this;
        r117.k(new ApiException(40001), null);
    L350:
        r221 = BuildConfig.FLAVOR;
    L343:
        r220 = BuildConfig.FLAVOR;
        goto L344
    L336:
        r154 = 1;
        goto L337
    L332:
        r219 = null;
        goto L333
    L295:
        r139 = 0;
        goto L296
    L286:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r0) == false) goto L288;
        r216 = r0;
        goto L289
    L282:
        r215 = 0;
    L278:
        r108 = "gift";
        goto L279
    L271:
        if (TextUtils.isEmpty(r105) == true) goto L273;
        r214 = true;
        goto L274
    L353:
        com.bytedance.android.livesdk.gift.model.p r158 = null;
    L355:
        final Ref.BooleanRef r159 = new Ref.BooleanRef();
        i12.e r160 = i12.o.b();
        if (r160 == null) goto L358;
        Object r161 = com.bytedance.android.scope.m.e.d(r160, GiftExtraRepo.class);
    L359:
        GiftExtraRepo r162 = (GiftExtraRepo) r161;
        if (r162 == null) goto L364;
        g0 r163 = r162.q(r8);
        if (r163 == null) goto L364;
        com.bytedance.android.livesdk.gift.model.p r164 = r163.getDiyGiftToolbarInfo();
    L365:
        if (r164 == null) goto L367;
        boolean r165 = true;
    L368:
        r159.element = r165;
        if (r210 != null) goto L379;
        com.bytedance.android.livesdk.revenue.room.a r166 = g02.a.d();
        if (r166 == null) goto L377;
        com.bytedance.live.datacontext.m r167 = r166.getRoom();
        if (r167 == null) goto L377;
        IRoom r168 = (IRoom) r167.getValue();
        if (r168 == null) goto L377;
        long r169 = r168.getRoomId();
    L378:
        Single r170 = Single.create(new t(r6, String.valueOf(r6.g()), r169, r311));
    L380:
        final Ref.IntRef r171 = r27;
        final Map<String, com.bytedance.android.livesdk.gift.platform.core.model.t> r172 = r26;
        final Ref.ObjectRef r173 = r213;
        final CompositeDisposable r222 = r311;
        RxUtilKt.c(r170.subscribeOn(AndroidSchedulers.mainThread()).subscribe(new AnonymousClass9(this, r6, r112, r8, r171, r172, r59, r173, r212, r11, r18, r159, r130, r131, r16, r210, r133, r25, r21, r222, r23, r24), new s(this)), r311);
        return;
    L377:
        r169 = 0;
        goto L378
    L379:
        r170 = Single.just(1);
        goto L380
    L367:
        r165 = false;
    L364:
        r164 = r158;
        goto L365
    L358:
        r161 = r158;
    L260:
        if (r100 < ((m2) r101.getValue(null, r102[33])).a()) goto L266;
        com.bytedance.android.live.incentive.exchange.c r174 = qa0.c.b.getService(com.bytedance.android.live.incentive.exchange.c.class);
        if (r174 == null) goto L266;
        if (r174.d(r99) != true) goto L266;
        r103 = true;
    L354:
        r158 = null;
        goto L355
    L244:
        r97 = null;
    L188:
        r73 = CollectionsKt.emptyList();
        goto L189
    L165:
        if (Intrinsics.areEqual(r120.getIdString(), r3) == false) goto L167;
        IBaseUser r175 = r120;
    L168:
        if (r175 == null) goto L170;
        r59.element = r120;
        Unit r176 = Unit.INSTANCE;
        goto L197
    L167:
        r175 = null;
        goto L168
    L162:
        r120 = null;
        goto L163
    L136:
        if (r113.intValue() != r114) goto L138;
        r115 = true;
    L131:
        r65 = null;
        goto L132
    L196:
        r213 = r110;
        r311 = r14;
        goto L197
    L122:
        r310 = false;
        goto L123
    L118:
        r58 = null;
    L83:
        if (r11 > 0) goto L85;
    L109:
        long r177 = 0;
    L110:
        if (r210 == null) goto L112;
        r210.getDiamondCount();
    L112:
        if (r210 == null) goto L114;
        r56 = (r210.getDiamondCount() + ((int) r177)) * r21;
        goto L115
    L114:
        r56 = 0;
        goto L115
    L85:
        if (((Boolean) v.b.getValue(null, v.a[0])).booleanValue() == false) goto L109;
        i12.e r178 = i12.o.b();
        if (r178 == null) goto L89;
        Object r179 = com.bytedance.android.scope.m.e.d(r178, GiftExtraRepo.class);
    L90:
        GiftExtraRepo r180 = (GiftExtraRepo) r179;
        if (r180 == null) goto L109;
        g0 r181 = r180.q(r8);
        if (r181 == null) goto L109;
        List<l1> r182 = r181.getGiftBuffInfos();
        if (r182 == null) goto L109;
        Iterator<T> r183 = r182.iterator();
    L98:
        if (r183.hasNext() == false) goto L105;
        Object r184 = r183.next();
        if (((l1) r184).getBuffLevel() != r11) goto L102;
        boolean r185 = true;
    L103:
        if (r185 == false) goto L98;
    L106:
        l1 r186 = (l1) r184;
        if (r186 == null) goto L109;
        r177 = r186.getBuffDiamondCount();
        goto L110
    L102:
        r185 = false;
        goto L103
    L105:
        r184 = null;
        goto L106
    L89:
        r179 = null;
    L73:
        if (TextUtils.isEmpty(null) == true) goto L76;
        r110.element = null;
    L53:
        r40 = null;
        goto L54
    L47:
        r26 = r7;
        r27 = r10;
        r25 = r13;
    L23:
        r20 = BuildConfig.FLAVOR;
        goto L25
    L17:
        r15 = "fans_club_panel";
        goto L18
    L10:
        if ((r5 instanceof Integer) == false) goto L13;
        r9 = Intrinsics.areEqual(r5, 1);
        goto L12
    L13:
        r24 = false;
        goto L15
    L5:
        r16 = 0;
        goto L6
    }

    public final void k(Throwable r13, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.x> r14) {
        JSONObject r0 = new JSONObject();
        if (r14 == null) goto L8;
        Iterator<T> r1 = r14.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((com.bytedance.android.livesdk.gift.platform.core.model.x) r1.next()).a(r0);
    L8:
        j(r0);
        StringBuilder r2 = new StringBuilder("finish: ");
        if (r14 == null) goto L11;
        String r15 = CollectionsKt.joinToString$default(r14, null, null, null, 0, null, SendGiftMethod$finish$2.INSTANCE, 31, null);
    L12:
        r2.append(r15);
        ALogger.i("GiftTransaction", r2.toString());
    L24:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        if ((r13 instanceof ApiException) == false) goto L20;
        r0.put("error_code", ((ApiException) r13).getErrorCode());     // Catch: JSONException -> L24
        if ((r13 instanceof ApiServerException) == false) goto L18;
        r0.put("error_msg", ((ApiServerException) r13).getPrompt());     // Catch: JSONException -> L24
    L18:
        finishWithResult(r0);     // Catch: JSONException -> L24
        return;
    L20:
        if (ay0.c.d() == false) goto L22;
        finishWithFailure(new RuntimeException("2: " + r13.getMessage()));     // Catch: JSONException -> L24
        return;
    L22:
        finishWithFailure(r13);     // Catch: JSONException -> L24
        return;
    L11:
        r15 = null;
        goto L12
    }

    public final void l(a r4, int r5) {
        Map<String, com.bytedance.android.livesdk.gift.platform.core.model.t> r0 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.f();
        com.bytedance.android.livesdk.gift.platform.core.model.t r1 = r0.get(r4.j());
        if (r1 == null) goto L13;
        r1.finish();
        TypeIntrinsics.asMutableMap(r0).remove(r4.j());
    L13:
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L7
        j(r6);     // Catch: JSONException -> L7
        r6.put("error_code", r5);     // Catch: JSONException -> L7
        finishWithResult(r6);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        if (ay0.c.d() == false) goto L11;
        k(new RuntimeException("b: " + e.getMessage()), null);
        return;
    L11:
        k(e, null);
    }

    public final void m(a r11, p2 r13, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.x> r14) {
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L44
        if (r14 == null) goto L9;
        Iterator<T> r15 = r14.iterator();     // Catch: JSONException -> L44
    L7:
        if (r15.hasNext() == false) goto L9;
        ((com.bytedance.android.livesdk.gift.platform.core.model.x) r15.next()).a(r1);     // Catch: JSONException -> L44
    L9:
        j(r1);     // Catch: JSONException -> L44
        r1.put("error_code", 0);     // Catch: JSONException -> L44
        JSONArray r16 = new JSONArray();     // Catch: JSONException -> L44
        Iterator<y1> r17 = r13.getGifts().iterator();     // Catch: JSONException -> L44
    L11:
        if (r17.hasNext() == false) goto L42;
        y1 r3 = r17.next();     // Catch: JSONException -> L44
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L44
        r4.put("gift_id", r3.getGiftId());     // Catch: JSONException -> L44
        r4.put("group_count", r3.getGroupCount());     // Catch: JSONException -> L44
        h2 r5 = jc1.k.n(IGiftService.class).findLiteGiftById(r3.getGiftId());     // Catch: JSONException -> L44
        boolean r7 = true;
        if (r5 == null) goto L15;
        int r6 = r5.getType();     // Catch: JSONException -> L44
    L16:
        r4.put("gift_type", r6);     // Catch: JSONException -> L44
        long r8 = r3.getComboCount();     // Catch: JSONException -> L44
        if (r11.n() != 3) goto L19;
    L22:
        if (r7 == false) goto L30;
        WishComboDataLog r9 = this.a;     // Catch: JSONException -> L44
        if (r9 == null) goto L30;
        HashMap r10 = r9.getGroupCountMap();     // Catch: JSONException -> L44
        if (r10 == null) goto L30;
        String r18 = r11.j();     // Catch: JSONException -> L44
        if (r18 == null) goto L30;
        r10.put(r18, Long.valueOf(r8));     // Catch: JSONException -> L44
    L30:
        r4.put("combo_count", r8);     // Catch: JSONException -> L44
        if (r3.getGiftBanner() == null) goto L41;
        com.bytedance.android.livesdk.gift.model.e0 r19 = r3.getGiftBanner();     // Catch: JSONException -> L44
        if (r19 == null) goto L35;
        Long r20 = r19.availableBoxCount;     // Catch: JSONException -> L44
    L36:
        r4.put("box_count", r20);     // Catch: JSONException -> L44
        com.bytedance.android.livesdk.gift.model.e0 r21 = r3.getGiftBanner();     // Catch: JSONException -> L44
        if (r21 == null) goto L39;
        Long r23 = r21.boxId;     // Catch: JSONException -> L44
    L40:
        r4.put("box_id", r23);     // Catch: JSONException -> L44
        goto L41
    L39:
        r23 = null;
        goto L40
    L35:
        r20 = null;
    L41:
        r16.put(r4);     // Catch: JSONException -> L44
        goto L11
    L19:
        if (r11.n() == 4) goto L22;
        r7 = false;
        goto L22
    L15:
        r6 = 1;
        goto L16
    L42:
        r1.put("result_list", r16);     // Catch: JSONException -> L44
        finishWithResult(r1);     // Catch: JSONException -> L44
        return;
    L44:
        e = move-exception;
        k(new RuntimeException("c: " + e.getMessage()), null);
    }
}
