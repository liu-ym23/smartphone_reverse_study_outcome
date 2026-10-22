package com.larus.account.saas.coreapi;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/coreapi/IAccountFrontierMessageHandler;", "", "Priority", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountFrontierMessageHandler {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/account/saas/coreapi/IAccountFrontierMessageHandler$Priority;", "", "", "value", "I", "getValue", "()I", "DEFAULT", "HIGH", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
    public static final enum Priority extends Enum<Priority> {
        public static final Priority DEFAULT = null;
        public static final Priority HIGH = null;
        public static final /* synthetic */ Priority[] a = null;
        private final int value;

        public static Priority valueOf(String r1) {
            return (Priority) a.a(Priority.class, r1);
        }

        public static Priority[] values() {
            return (Priority[]) a.clone();
        }

        static {
            Priority r0 = new Priority("DEFAULT", 0, 0);
            DEFAULT = r0;
            Priority r1 = new Priority("HIGH", 1, 100);
            HIGH = r1;
            a = new Priority[]{r0, r1};
        }

        public final int getValue() {
            return this.value;
        }

        public Priority(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    boolean a(int r1, String r2);

    Priority priority();
}
