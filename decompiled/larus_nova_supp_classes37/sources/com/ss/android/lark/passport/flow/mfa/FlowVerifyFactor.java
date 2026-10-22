package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0080\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0016\u0017B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowVerifyFactor;", "", "wireKey", "", "actionType", "", "inputKind", "Lcom/ss/android/lark/passport/flow/mfa/FlowVerifyFactor$InputKind;", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILcom/ss/android/lark/passport/flow/mfa/FlowVerifyFactor$InputKind;)V", "getWireKey", "()Ljava/lang/String;", "getActionType", "()I", "getInputKind", "()Lcom/ss/android/lark/passport/flow/mfa/FlowVerifyFactor$InputKind;", "PHONE", "EMAIL", "SPARE", "OTP", "PASSWORD", "BIDP", "InputKind", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum FlowVerifyFactor extends Enum<FlowVerifyFactor> {
    public static final FlowVerifyFactor BIDP = null;
    public static final a Companion = null;
    public static final FlowVerifyFactor EMAIL = null;
    public static final FlowVerifyFactor OTP = null;
    public static final FlowVerifyFactor PASSWORD = null;
    public static final FlowVerifyFactor PHONE = null;
    public static final FlowVerifyFactor SPARE = null;
    public static final Set<FlowVerifyFactor> a = null;
    public static final Set<Integer> b = null;
    public static final /* synthetic */ FlowVerifyFactor[] c = null;
    public static final /* synthetic */ EnumEntries d = null;
    private final int actionType;
    private final InputKind inputKind;
    private final String wireKey;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowVerifyFactor$InputKind;", "", "<init>", "(Ljava/lang/String;I)V", "CODE", "OTP", "PASSWORD", "BIDP", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum InputKind extends Enum<InputKind> {
        public static final InputKind BIDP = null;
        public static final InputKind CODE = null;
        public static final InputKind OTP = null;
        public static final InputKind PASSWORD = null;
        public static final /* synthetic */ InputKind[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<InputKind> getEntries() {
            return b;
        }

        static {
            InputKind r0 = new InputKind("CODE", 0);
            CODE = r0;
            InputKind r1 = new InputKind("OTP", 1);
            OTP = r1;
            InputKind r3 = new InputKind("PASSWORD", 2);
            PASSWORD = r3;
            InputKind r5 = new InputKind("BIDP", 3);
            BIDP = r5;
            InputKind[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static InputKind[] values() {
            return (InputKind[]) a.clone();
        }

        public static InputKind valueOf(String r1) {
            return (InputKind) r27.a.a(InputKind.class, r1);
        }

        public InputKind(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }

        public static FlowVerifyFactor a(int r3) {
            Iterator r0 = FlowVerifyFactor.access$getSupported$cp().iterator();
        L4:
            if (r0.hasNext() == false) goto L11;
            Object r1 = r0.next();
            if (((FlowVerifyFactor) r1).getActionType() != r3) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == false) goto L4;
        L13:
            return (FlowVerifyFactor) r1;
        L8:
            r2 = false;
            goto L9
        L11:
            r1 = null;
            goto L13
        }

        public static boolean b(int r1) {
            return FlowVerifyFactor.access$getSupportedActionTypes$cp().contains(Integer.valueOf(r1));
        }
    }

    public static EnumEntries<FlowVerifyFactor> getEntries() {
        return d;
    }

    static {
        InputKind r13 = InputKind.CODE;
        FlowVerifyFactor r6 = new FlowVerifyFactor("PHONE", 0, "verify_code_mobile", 12, r13);
        PHONE = r6;
        FlowVerifyFactor r0 = new FlowVerifyFactor("EMAIL", 1, "verify_code_email", 11, r13);
        EMAIL = r0;
        FlowVerifyFactor r1 = new FlowVerifyFactor("SPARE", 2, "verify_code_spare", 43, r13);
        SPARE = r1;
        FlowVerifyFactor r2 = new FlowVerifyFactor("OTP", 3, "verify_otp", 42, InputKind.OTP);
        OTP = r2;
        FlowVerifyFactor r3 = new FlowVerifyFactor("PASSWORD", 4, "verify_pwd", 41, InputKind.PASSWORD);
        PASSWORD = r3;
        FlowVerifyFactor r4 = new FlowVerifyFactor("BIDP", 5, "verify_b_idp", 23, InputKind.BIDP);
        BIDP = r4;
        FlowVerifyFactor[] r5 = {r6, r0, r1, r2, r3, r4};
        c = r5;
        d = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
        Set<FlowVerifyFactor> r7 = SetsKt.setOf(new FlowVerifyFactor[]{r6, r0, r4});
        a = r7;
        Set<FlowVerifyFactor> r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r9.add(Integer.valueOf(((FlowVerifyFactor) r10.next()).actionType));
        goto L4
    L6:
        b = CollectionsKt.toSet(r9);
    }

    public static FlowVerifyFactor[] values() {
        return (FlowVerifyFactor[]) c.clone();
    }

    public static final /* synthetic */ Set access$getSupported$cp() {
        return a;
    }

    public static final /* synthetic */ Set access$getSupportedActionTypes$cp() {
        return b;
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final InputKind getInputKind() {
        return this.inputKind;
    }

    public final String getWireKey() {
        return this.wireKey;
    }

    public static FlowVerifyFactor valueOf(String r1) {
        return (FlowVerifyFactor) r27.a.a(FlowVerifyFactor.class, r1);
    }

    public FlowVerifyFactor(String r1, int r2, String r3, int r4, InputKind r5) {
        super(r1, r2);
        this.wireKey = r3;
        this.actionType = r4;
        this.inputKind = r5;
    }
}
