package com.ss.android.lark.chameleon.basewebview;

import com.ss.android.lark.chat.constant.ChatFromType;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/basewebview/BizType;", BuildConfig.FLAVOR, "biz", BuildConfig.FLAVOR, "(Ljava/lang/String;)V", "getBiz", "Companion", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BizType {
    private static final BizType BITABLE_SUBPAGE = null;
    private static final BizType CALENDAR = null;
    public static final Companion Companion = null;
    private static final BizType DOCS = null;
    private static final BizType GADGET = null;
    private static final BizType LARKWEB = null;
    private static final BizType MAIL = null;
    private static final BizType PASSPORT = null;
    private static final BizType UNKNOWN = null;
    private String biz;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chameleon/basewebview/BizType$Companion;", BuildConfig.FLAVOR, "()V", "BITABLE_SUBPAGE", "Lcom/ss/android/lark/chameleon/basewebview/BizType;", "getBITABLE_SUBPAGE", "()Lcom/ss/android/lark/chameleon/basewebview/BizType;", "CALENDAR", "getCALENDAR", "DOCS", "getDOCS", "GADGET", "getGADGET", "LARKWEB", "getLARKWEB", "MAIL", "getMAIL", "PASSPORT", "getPASSPORT", "UNKNOWN", "getUNKNOWN", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final BizType getBITABLE_SUBPAGE() {
            return BizType.access$getBITABLE_SUBPAGE$cp();
        }

        public final BizType getCALENDAR() {
            return BizType.access$getCALENDAR$cp();
        }

        public final BizType getDOCS() {
            return BizType.access$getDOCS$cp();
        }

        public final BizType getGADGET() {
            return BizType.access$getGADGET$cp();
        }

        public final BizType getLARKWEB() {
            return BizType.access$getLARKWEB$cp();
        }

        public final BizType getMAIL() {
            return BizType.access$getMAIL$cp();
        }

        public final BizType getPASSPORT() {
            return BizType.access$getPASSPORT$cp();
        }

        public final BizType getUNKNOWN() {
            return BizType.access$getUNKNOWN$cp();
        }
    }

    public BizType() {
        String r0 = null;
        this(r0, 1, r0);
    }

    static {
        Companion = new Companion(null);
        DOCS = new BizType("docs");
        LARKWEB = new BizType("larkweb");
        GADGET = new BizType("gadget");
        MAIL = new BizType("mail");
        CALENDAR = new BizType(ChatFromType.CALENDAR);
        PASSPORT = new BizType("passport");
        BITABLE_SUBPAGE = new BizType("webSubPage");
        UNKNOWN = new BizType("unknown");
    }

    public final String getBiz() {
        String r0 = this.biz;
        if (r0 != null) goto L6;
        return "unknown";
    L6:
        return r0;
    }

    public static final /* synthetic */ BizType access$getBITABLE_SUBPAGE$cp() {
        return BITABLE_SUBPAGE;
    }

    public static final /* synthetic */ BizType access$getCALENDAR$cp() {
        return CALENDAR;
    }

    public static final /* synthetic */ BizType access$getDOCS$cp() {
        return DOCS;
    }

    public static final /* synthetic */ BizType access$getGADGET$cp() {
        return GADGET;
    }

    public static final /* synthetic */ BizType access$getLARKWEB$cp() {
        return LARKWEB;
    }

    public static final /* synthetic */ BizType access$getMAIL$cp() {
        return MAIL;
    }

    public static final /* synthetic */ BizType access$getPASSPORT$cp() {
        return PASSPORT;
    }

    public static final /* synthetic */ BizType access$getUNKNOWN$cp() {
        return UNKNOWN;
    }

    public BizType(String r1) {
        this.biz = r1;
    }

    public /* synthetic */ BizType(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "unknown";
    L5:
        this(r1);
    }
}
