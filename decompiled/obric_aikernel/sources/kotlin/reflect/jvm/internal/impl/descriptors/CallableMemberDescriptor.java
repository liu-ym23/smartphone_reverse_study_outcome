package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public interface CallableMemberDescriptor extends CallableDescriptor, MemberDescriptor {

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind DECLARATION = null;
        public static final Kind DELEGATION = null;
        public static final Kind FAKE_OVERRIDE = null;
        public static final Kind SYNTHESIZED = null;

        static {
            Kind r10 = new Kind("DECLARATION", 0);
            DECLARATION = r10;
            Kind r11 = new Kind("FAKE_OVERRIDE", 1);
            FAKE_OVERRIDE = r11;
            Kind r12 = new Kind("DELEGATION", 2);
            DELEGATION = r12;
            Kind r13 = new Kind("SYNTHESIZED", 3);
            SYNTHESIZED = r13;
            $VALUES = new Kind[]{r10, r11, r12, r13};
        }

        private Kind(String r10, int r11) {
            super(r10, r11);
        }

        public static Kind valueOf(String r10) {
            return (Kind) Enum.valueOf(Kind.class, r10);
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
    }

    CallableMemberDescriptor copy(DeclarationDescriptor r10, Modality r11, DescriptorVisibility r12, Kind r13, boolean r14);

    Kind getKind();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    CallableMemberDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    Collection<? extends CallableMemberDescriptor> getOverriddenDescriptors();

    void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r10);
}
