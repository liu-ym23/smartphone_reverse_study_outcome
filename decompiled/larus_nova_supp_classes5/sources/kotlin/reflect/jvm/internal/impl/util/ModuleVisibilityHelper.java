package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface ModuleVisibilityHelper {

    public static final class EMPTY implements ModuleVisibilityHelper {
        public static final EMPTY INSTANCE = null;

        static {
            INSTANCE = new EMPTY();
        }

        private EMPTY() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper
        public boolean isInFriendModule(DeclarationDescriptor r2, DeclarationDescriptor r3) {
            Intrinsics.checkNotNullParameter(r2, "what");
            Intrinsics.checkNotNullParameter(r3, "from");
            return true;
        }
    }

    boolean isInFriendModule(DeclarationDescriptor r1, DeclarationDescriptor r2);
}
