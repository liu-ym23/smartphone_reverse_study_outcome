package com.lynx.tasm.behavior;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.image.FlattenUIImage;
import com.lynx.tasm.behavior.ui.image.InlineImageShadowNode;
import com.lynx.tasm.behavior.ui.image.UIImage;
import com.lynx.tasm.image.AutoSizeImage;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final Map<String, com.lynx.tasm.behavior.a> a = null;

    public static class a extends com.lynx.tasm.behavior.a {
        public a() {
            super("image", true, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new AutoSizeImage();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxFlattenUI createFlattenUIWithParams(LynxContext r2, Object r3) {
            return new FlattenUIImage(r2, r3);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return new UIImage(r2, r3);
        }
    }

    public static class b extends com.lynx.tasm.behavior.a {
        public b() {
            super("inline-image", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new InlineImageShadowNode();
        }
    }

    static {
        HashMap r0 = new HashMap();
        a = r0;
        r0.put("image", new a());
        r0.put("inline-image", new b());
    }
}
