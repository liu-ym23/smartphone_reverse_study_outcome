package com.lynx.canvas;

import java.util.List;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class KryptonPermissionService extends KryptonService {

    public static final enum PermissionType extends Enum<PermissionType> {
        private static final /* synthetic */ PermissionType[] $VALUES = null;
        public static final PermissionType CAMERA = null;
        public static final PermissionType RECORD_AUDIO = null;

        static {
            PermissionType r0 = new PermissionType("CAMERA", 0);
            CAMERA = r0;
            PermissionType r1 = new PermissionType("RECORD_AUDIO", 1);
            RECORD_AUDIO = r1;
            $VALUES = new PermissionType[]{r0, r1};
        }

        public static PermissionType[] values() {
            return (PermissionType[]) $VALUES.clone();
        }

        public static PermissionType valueOf(String r1) {
            return (PermissionType) a.a(PermissionType.class, r1);
        }

        private PermissionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface Responder {
        void onResponse(boolean r1);
    }

    public abstract boolean requestGranted(List<PermissionType> r1);

    public abstract void requestPermission(List<PermissionType> r1, Responder r2);

    public KryptonPermissionService() {
    }
}
