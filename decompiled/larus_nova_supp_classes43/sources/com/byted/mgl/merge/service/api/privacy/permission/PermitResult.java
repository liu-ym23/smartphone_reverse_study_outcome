package com.byted.mgl.merge.service.api.privacy.permission;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\tB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/byted/mgl/merge/service/api/privacy/permission/PermitResult;", "", "permission", "", "resultType", "Lcom/byted/mgl/merge/service/api/privacy/permission/PermitResult$Type;", "neverAsk", "", "(Ljava/lang/String;Lcom/byted/mgl/merge/service/api/privacy/permission/PermitResult$Type;Z)V", "Type", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public final class PermitResult {
    public final boolean neverAsk;
    public final String permission;
    public final Type resultType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/byted/mgl/merge/service/api/privacy/permission/PermitResult$Type;", "", "(Ljava/lang/String;I)V", "GRANTED", "DENIED", "NOT_FOUND", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type DENIED = null;
        public static final Type GRANTED = null;
        public static final Type NOT_FOUND = null;

        static {
            Type r1 = new Type("GRANTED", 0);
            GRANTED = r1;
            Type r10 = new Type("DENIED", 1);
            DENIED = r10;
            Type r11 = new Type("NOT_FOUND", 2);
            NOT_FOUND = r11;
            $VALUES = new Type[]{r1, r10, r11};
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String r1, int r10) {
            super(r1, r10);
        }
    }

    public PermitResult(String r1, Type r10, boolean r11) {
        this.permission = r1;
        this.resultType = r10;
        this.neverAsk = r11;
    }
}
