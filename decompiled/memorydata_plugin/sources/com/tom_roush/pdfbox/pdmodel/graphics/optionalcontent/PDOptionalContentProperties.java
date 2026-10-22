package com.tom_roush.pdfbox.pdmodel.graphics.optionalcontent;

import com.tom_roush.pdfbox.a.b;
import com.tom_roush.pdfbox.a.d;
import com.tom_roush.pdfbox.a.i;
import com.tom_roush.pdfbox.pdmodel.common.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class PDOptionalContentProperties implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f16272a;

    public static final enum BaseState extends Enum<BaseState> {
        private static final /* synthetic */ BaseState[] $VALUES = null;
        public static final BaseState OFF = null;
        public static final BaseState ON = null;
        public static final BaseState UNCHANGED = null;
        private final i name;

        static {
            BaseState r0 = new BaseState("ON", 0, i.fF);
            ON = r0;
            BaseState r1 = new BaseState("OFF", 1, i.fD);
            OFF = r1;
            BaseState r2 = new BaseState("UNCHANGED", 2, i.iG);
            UNCHANGED = r2;
            $VALUES = new BaseState[]{r0, r1, r2};
        }

        private BaseState(String r1, int r2, i r3) {
            super(r1, r2);
            this.name = r3;
        }

        public static BaseState valueOf(i r0) {
            if (r0 != null) goto L6;
            return ON;
        L6:
            return valueOf(r0.a().toUpperCase());
        }

        public static BaseState valueOf(String r2) {
            return (BaseState) ZeusTransformUtils.preCheckCast(Enum.valueOf(BaseState.class, r2), BaseState.class, "com.obric.memorydata.plugin");
        }

        public static BaseState[] values() {
            return (BaseState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BaseState[].class, "com.obric.memorydata.plugin");
        }

        public i getName() {
            return this.name;
        }
    }

    public d a() {
        return this.f16272a;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ b e() {
        return a();
    }
}
