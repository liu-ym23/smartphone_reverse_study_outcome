package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public interface ModuleVisibilityHelper {

    public static final class EMPTY implements ModuleVisibilityHelper {
        public static final EMPTY INSTANCE = null;

        static {
            INSTANCE = new EMPTY();
        }

        private EMPTY() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper
        public boolean isInFriendModule(DeclarationDescriptor r10, DeclarationDescriptor r11) {
            Intrinsics.checkNotNullParameter(r10, "what");
            Intrinsics.checkNotNullParameter(r11, "from");
            return true;
        }
    }

    boolean isInFriendModule(DeclarationDescriptor r10, DeclarationDescriptor r11);
}
