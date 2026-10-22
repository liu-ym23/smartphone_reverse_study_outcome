package com.obric.cae.location.zpp;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;

/* JADX INFO: loaded from: classes.dex */
public final class StarZppEvent {
    private static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_com_obric_cae_location_zpp_StarZppData_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_location_zpp_StarZppData_fieldAccessorTable = null;
    static final Descriptors.Descriptor internal_static_com_obric_cae_location_zpp_StarZppProto_descriptor = null;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_cae_location_zpp_StarZppProto_fieldAccessorTable = null;

    static {
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rStarZpp.proto\u0012\u001acom.obric.cae.location.zpp\"D\n\fStarZppProto\u00124\n\u0003zpp\u0018\u0001 \u0001(\u000b2'.com.obric.cae.location.zpp.StarZppData\"\u0086\u0001\n\u000bStarZppData\u0012\u0015\n\rmodel_version\u0018\u0001 \u0002(\t\u0012\u0011\n\ttimestamp\u0018\u0002 \u0003(\u0004\u0012\u0012\n\nconfidence\u0018\u0003 \u0003(\u0002\u0012\u0015\n\rfeature_array\u0018\u0004 \u0003(\u0002\u0012\f\n\u0004eval\u0018\u0005 \u0003(\u0002\u0012\u0014\n\fzpp_strategy\u0018\u0006 \u0001(\rB\u0010B\fStarZppEventP\u0001"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r8 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_obric_cae_location_zpp_StarZppProto_descriptor = r8;
        internal_static_com_obric_cae_location_zpp_StarZppProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r8, new String[]{"Zpp"});
        Descriptors.Descriptor r10 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_obric_cae_location_zpp_StarZppData_descriptor = r10;
        internal_static_com_obric_cae_location_zpp_StarZppData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r10, new String[]{"ModelVersion", BwdlDropProvider.BwdlDropEntry.TIMESTAMP, "Confidence", "FeatureArray", "Eval", "ZppStrategy"});
    }

    private StarZppEvent() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry r8) {
        registerAllExtensions(r8);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r8) {
    }
}
