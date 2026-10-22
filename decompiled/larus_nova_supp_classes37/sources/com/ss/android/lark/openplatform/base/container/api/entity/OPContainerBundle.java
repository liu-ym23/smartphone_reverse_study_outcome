package com.ss.android.lark.openplatform.base.container.api.entity;

import android.content.Context;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class OPContainerBundle {
    public OPTrace a;

    public static final enum API_TYPE extends Enum<API_TYPE> {
        public static final API_TYPE INVOKE = null;
        public static final API_TYPE ON = null;
        public static final /* synthetic */ API_TYPE[] a = null;
        private final String type;

        static {
            API_TYPE r0 = new API_TYPE("INVOKE", 0, "invoke");
            INVOKE = r0;
            API_TYPE r1 = new API_TYPE("ON", 1, "on");
            ON = r1;
            a = new API_TYPE[]{r0, r1};
        }

        public static API_TYPE[] values() {
            return (API_TYPE[]) a.clone();
        }

        public String getType() {
            return this.type;
        }

        public static API_TYPE valueOf(String r1) {
            return (API_TYPE) a.a(API_TYPE.class, r1);
        }

        public API_TYPE(String r1, int r2, String r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public Context getContext() {
        return null;
    }
}
