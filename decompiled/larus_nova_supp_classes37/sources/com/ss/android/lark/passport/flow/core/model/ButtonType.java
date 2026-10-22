package com.ss.android.lark.passport.flow.core.model;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b5\b\u0086\u0081\u0002\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6¨\u00068"}, d2 = {"Lcom/ss/android/lark/passport/flow/core/model/ButtonType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "NEXT", "REGISTER", "JOIN", "JOIN_SCAN", "JOIN_CODE", "CREATE_TENANT", "CREATE_PERSONAL", "APPEAL", "VERIFY", "KNOWN", "VERIFY_EMAIL", "VERIFY_PHONE", "QR_AUTH_SINGLE", "QR_AUTH_ALL", "QR_AUTH_AUTHZ", "DEPROV_KNOWN", "DEPROV_DELETE_WALLET", "RETRIEVE_NEED_MOBILE_CANCEL", "VERIFY_CIDP", "VERIFY_GOOGLE", "VERIFY_APPLE_ID", "VERIFY_TENANT_DOMAIN", "VERIFY_B_IDP", "OPT_IN_ACCEPT", "OPT_IN_NOT_ACCEPT", "OPT_IN_SKIP_SELECT", "REAL_NAME_SKIP_VERIFY", "REAL_NAME_VERIFY", "JOIN_DIALOG_REFUSE_TENANT", "OPEN_URL", "VERIFY_PASSWORD", "VERIFY_OTP", "VERIFY_SPARE", "VERIFY_MO", "SESSION_REAUTH_GUIDEDIALOG", "SESSION_REAUTH_SWITCH", "SESSION_REAUTH_EXEMPT_REMIND", "QR_LOGIN_CONFIRM_AUTH", "QR_LOGIN_CONFIRM_CANCEL", "VERIFY_FIDO", "SWITCH_AUTH", "SET_PASSWORD", "SESSION_CONFIRM_CANCEL", "QR_LOGIN_SHOW", "VERIFY_DOUBAO", "CREATE_DOUBAO_ACCOUNT", "Companion", "flow-passport-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum ButtonType extends Enum<ButtonType> {
    public static final ButtonType APPEAL = null;
    public static final ButtonType CREATE_DOUBAO_ACCOUNT = null;
    public static final ButtonType CREATE_PERSONAL = null;
    public static final ButtonType CREATE_TENANT = null;
    public static final a Companion = null;
    public static final ButtonType DEPROV_DELETE_WALLET = null;
    public static final ButtonType DEPROV_KNOWN = null;
    public static final ButtonType JOIN = null;
    public static final ButtonType JOIN_CODE = null;
    public static final ButtonType JOIN_DIALOG_REFUSE_TENANT = null;
    public static final ButtonType JOIN_SCAN = null;
    public static final ButtonType KNOWN = null;
    public static final ButtonType NEXT = null;
    public static final ButtonType NORMAL = null;
    public static final ButtonType OPEN_URL = null;
    public static final ButtonType OPT_IN_ACCEPT = null;
    public static final ButtonType OPT_IN_NOT_ACCEPT = null;
    public static final ButtonType OPT_IN_SKIP_SELECT = null;
    public static final ButtonType QR_AUTH_ALL = null;
    public static final ButtonType QR_AUTH_AUTHZ = null;
    public static final ButtonType QR_AUTH_SINGLE = null;
    public static final ButtonType QR_LOGIN_CONFIRM_AUTH = null;
    public static final ButtonType QR_LOGIN_CONFIRM_CANCEL = null;
    public static final ButtonType QR_LOGIN_SHOW = null;
    public static final ButtonType REAL_NAME_SKIP_VERIFY = null;
    public static final ButtonType REAL_NAME_VERIFY = null;
    public static final ButtonType REGISTER = null;
    public static final ButtonType RETRIEVE_NEED_MOBILE_CANCEL = null;
    public static final ButtonType SESSION_CONFIRM_CANCEL = null;
    public static final ButtonType SESSION_REAUTH_EXEMPT_REMIND = null;
    public static final ButtonType SESSION_REAUTH_GUIDEDIALOG = null;
    public static final ButtonType SESSION_REAUTH_SWITCH = null;
    public static final ButtonType SET_PASSWORD = null;
    public static final ButtonType SWITCH_AUTH = null;
    public static final ButtonType VERIFY = null;
    public static final ButtonType VERIFY_APPLE_ID = null;
    public static final ButtonType VERIFY_B_IDP = null;
    public static final ButtonType VERIFY_CIDP = null;
    public static final ButtonType VERIFY_DOUBAO = null;
    public static final ButtonType VERIFY_EMAIL = null;
    public static final ButtonType VERIFY_FIDO = null;
    public static final ButtonType VERIFY_GOOGLE = null;
    public static final ButtonType VERIFY_MO = null;
    public static final ButtonType VERIFY_OTP = null;
    public static final ButtonType VERIFY_PASSWORD = null;
    public static final ButtonType VERIFY_PHONE = null;
    public static final ButtonType VERIFY_SPARE = null;
    public static final ButtonType VERIFY_TENANT_DOMAIN = null;
    public static final Lazy<ButtonType[]> a = null;
    public static final /* synthetic */ ButtonType[] b = null;
    public static final /* synthetic */ EnumEntries c = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static ButtonType a(int r6) {
            ButtonType[] r0 = (ButtonType[]) ButtonType.access$getValues$delegate$cp().getValue();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            ButtonType r4 = r0[r3];
            if (r4.getValue() != r6) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r4 == null) goto L14;
            return r4;
        L14:
            return ButtonType.NORMAL;
        L7:
            r5 = false;
            goto L8
        L11:
            r4 = null;
            goto L12
        }
    }

    @JvmStatic
    public static final ButtonType fromValue(int r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public static EnumEntries<ButtonType> getEntries() {
        return c;
    }

    static {
        ButtonType r0 = new ButtonType("NORMAL", 0, 0);
        NORMAL = r0;
        ButtonType r1 = new ButtonType("NEXT", 1, 1);
        NEXT = r1;
        ButtonType r3 = new ButtonType("REGISTER", 2, 2);
        REGISTER = r3;
        ButtonType r5 = new ButtonType("JOIN", 3, 3);
        JOIN = r5;
        ButtonType r7 = new ButtonType("JOIN_SCAN", 4, 4);
        JOIN_SCAN = r7;
        ButtonType r9 = new ButtonType("JOIN_CODE", 5, 5);
        JOIN_CODE = r9;
        ButtonType r11 = new ButtonType("CREATE_TENANT", 6, 6);
        CREATE_TENANT = r11;
        ButtonType r13 = new ButtonType("CREATE_PERSONAL", 7, 7);
        CREATE_PERSONAL = r13;
        ButtonType r15 = new ButtonType("APPEAL", 8, 8);
        APPEAL = r15;
        ButtonType r14 = new ButtonType("VERIFY", 9, 9);
        VERIFY = r14;
        ButtonType r10 = new ButtonType("KNOWN", 10, 10);
        KNOWN = r10;
        ButtonType r8 = new ButtonType("VERIFY_EMAIL", 11, 11);
        VERIFY_EMAIL = r8;
        ButtonType r6 = new ButtonType("VERIFY_PHONE", 12, 12);
        VERIFY_PHONE = r6;
        ButtonType r4 = new ButtonType("QR_AUTH_SINGLE", 13, 13);
        QR_AUTH_SINGLE = r4;
        ButtonType r2 = new ButtonType("QR_AUTH_ALL", 14, 14);
        QR_AUTH_ALL = r2;
        ButtonType r12 = new ButtonType("QR_AUTH_AUTHZ", 15, 15);
        QR_AUTH_AUTHZ = r12;
        ButtonType r16 = new ButtonType("DEPROV_KNOWN", 16, 16);
        DEPROV_KNOWN = r16;
        ButtonType r17 = new ButtonType("DEPROV_DELETE_WALLET", 17, 17);
        DEPROV_DELETE_WALLET = r17;
        ButtonType r18 = new ButtonType("RETRIEVE_NEED_MOBILE_CANCEL", 18, 18);
        RETRIEVE_NEED_MOBILE_CANCEL = r18;
        ButtonType r19 = new ButtonType("VERIFY_CIDP", 19, 19);
        VERIFY_CIDP = r19;
        ButtonType r20 = new ButtonType("VERIFY_GOOGLE", 20, 20);
        VERIFY_GOOGLE = r20;
        ButtonType r21 = new ButtonType("VERIFY_APPLE_ID", 21, 21);
        VERIFY_APPLE_ID = r21;
        ButtonType r22 = new ButtonType("VERIFY_TENANT_DOMAIN", 22, 22);
        VERIFY_TENANT_DOMAIN = r22;
        ButtonType r110 = new ButtonType("VERIFY_B_IDP", 23, 23);
        VERIFY_B_IDP = r110;
        ButtonType r23 = new ButtonType("OPT_IN_ACCEPT", 24, 24);
        OPT_IN_ACCEPT = r23;
        ButtonType r24 = new ButtonType("OPT_IN_NOT_ACCEPT", 25, 25);
        OPT_IN_NOT_ACCEPT = r24;
        ButtonType r111 = new ButtonType("OPT_IN_SKIP_SELECT", 26, 26);
        OPT_IN_SKIP_SELECT = r111;
        ButtonType r25 = new ButtonType("REAL_NAME_SKIP_VERIFY", 27, 27);
        REAL_NAME_SKIP_VERIFY = r25;
        ButtonType r26 = new ButtonType("REAL_NAME_VERIFY", 28, 28);
        REAL_NAME_VERIFY = r26;
        ButtonType r112 = new ButtonType("JOIN_DIALOG_REFUSE_TENANT", 29, 31);
        JOIN_DIALOG_REFUSE_TENANT = r112;
        ButtonType r27 = new ButtonType("OPEN_URL", 30, 32);
        OPEN_URL = r27;
        ButtonType r28 = new ButtonType("VERIFY_PASSWORD", 31, 41);
        VERIFY_PASSWORD = r28;
        ButtonType r29 = new ButtonType("VERIFY_OTP", 32, 42);
        VERIFY_OTP = r29;
        ButtonType r30 = new ButtonType("VERIFY_SPARE", 33, 43);
        VERIFY_SPARE = r30;
        ButtonType r31 = new ButtonType("VERIFY_MO", 34, 45);
        VERIFY_MO = r31;
        ButtonType r32 = new ButtonType("SESSION_REAUTH_GUIDEDIALOG", 35, 48);
        SESSION_REAUTH_GUIDEDIALOG = r32;
        ButtonType r33 = new ButtonType("SESSION_REAUTH_SWITCH", 36, 49);
        SESSION_REAUTH_SWITCH = r33;
        ButtonType r34 = new ButtonType("SESSION_REAUTH_EXEMPT_REMIND", 37, 50);
        SESSION_REAUTH_EXEMPT_REMIND = r34;
        ButtonType r35 = new ButtonType("QR_LOGIN_CONFIRM_AUTH", 38, 51);
        QR_LOGIN_CONFIRM_AUTH = r35;
        ButtonType r36 = new ButtonType("QR_LOGIN_CONFIRM_CANCEL", 39, 52);
        QR_LOGIN_CONFIRM_CANCEL = r36;
        ButtonType r37 = new ButtonType("VERIFY_FIDO", 40, 53);
        VERIFY_FIDO = r37;
        ButtonType r38 = new ButtonType("SWITCH_AUTH", 41, 54);
        SWITCH_AUTH = r38;
        ButtonType r39 = new ButtonType("SET_PASSWORD", 42, 55);
        SET_PASSWORD = r39;
        ButtonType r40 = new ButtonType("SESSION_CONFIRM_CANCEL", 43, 56);
        SESSION_CONFIRM_CANCEL = r40;
        ButtonType r41 = new ButtonType("QR_LOGIN_SHOW", 44, 59);
        QR_LOGIN_SHOW = r41;
        ButtonType r42 = new ButtonType("VERIFY_DOUBAO", 45, 60);
        VERIFY_DOUBAO = r42;
        ButtonType r43 = new ButtonType("CREATE_DOUBAO_ACCOUNT", 46, 63);
        CREATE_DOUBAO_ACCOUNT = r43;
        ButtonType[] r44 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r10, r8, r6, r4, r2, r12, r16, r17, r18, r19, r20, r21, r22, r110, r23, r24, r111, r25, r26, r112, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43};
        b = r44;
        c = EnumEntriesKt.enumEntries(r44);
        Companion = new a();
        a = LazyKt.lazy(ButtonType$Companion$values$2.INSTANCE);
    }

    public static ButtonType[] values() {
        return (ButtonType[]) b.clone();
    }

    public static final /* synthetic */ Lazy access$getValues$delegate$cp() {
        return a;
    }

    public final int getValue() {
        return this.value;
    }

    public static ButtonType valueOf(String r1) {
        return (ButtonType) r27.a.a(ButtonType.class, r1);
    }

    public ButtonType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
