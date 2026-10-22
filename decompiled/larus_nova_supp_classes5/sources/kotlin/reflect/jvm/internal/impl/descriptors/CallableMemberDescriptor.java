package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface CallableMemberDescriptor extends CallableDescriptor, MemberDescriptor {

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind DECLARATION = null;
        public static final Kind DELEGATION = null;
        public static final Kind FAKE_OVERRIDE = null;
        public static final Kind SYNTHESIZED = null;

        static {
            Kind r0 = new Kind("DECLARATION", 0);
            DECLARATION = r0;
            Kind r1 = new Kind("FAKE_OVERRIDE", 1);
            FAKE_OVERRIDE = r1;
            Kind r3 = new Kind("DELEGATION", 2);
            DELEGATION = r3;
            Kind r5 = new Kind("SYNTHESIZED", 3);
            SYNTHESIZED = r5;
            $VALUES = new Kind[]{r0, r1, r3, r5};
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        public boolean isReal() {
            if (this == FAKE_OVERRIDE) goto L5;
            return true;
        L5:
            return false;
        }

        public static Kind valueOf(String r1) {
            return (Kind) a.a(Kind.class, r1);
        }

        private Kind(String r1, int r2) {
            super(r1, r2);
        }
    }

    CallableMemberDescriptor copy(DeclarationDescriptor r1, Modality r2, DescriptorVisibility r3, Kind r4, boolean r5);

    Kind getKind();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    CallableMemberDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    Collection<? extends CallableMemberDescriptor> getOverriddenDescriptors();

    void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r1);
}
