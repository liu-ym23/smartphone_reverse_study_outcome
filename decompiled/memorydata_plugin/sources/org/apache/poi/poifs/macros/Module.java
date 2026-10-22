package org.apache.poi.poifs.macros;

import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface Module {

    public static final enum ModuleType extends Enum<ModuleType> {
        private static final /* synthetic */ ModuleType[] $VALUES = null;
        public static final ModuleType Class = null;
        public static final ModuleType Document = null;
        public static final ModuleType Module = null;

        static {
            ModuleType r0 = new ModuleType(i.f16175a, 0);
            Document = r0;
            ModuleType r1 = new ModuleType("Module", 1);
            Module = r1;
            ModuleType r3 = new ModuleType("Class", 2);
            Class = r3;
            $VALUES = new ModuleType[]{r0, r1, r3};
        }

        private ModuleType(String r1, int r2) {
            super(r1, r2);
        }

        public static ModuleType valueOf(String r2) {
            return (ModuleType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ModuleType.class, r2), ModuleType.class, "com.obric.memorydata.plugin");
        }

        public static ModuleType[] values() {
            return (ModuleType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ModuleType[].class, "com.obric.memorydata.plugin");
        }
    }
}
