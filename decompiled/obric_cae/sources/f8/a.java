package f8;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;
import com.obric.cae.provider.CaeProvider;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f7347a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f7348b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f7349c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f7350d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Descriptors.Descriptor f7351e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f7352f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Descriptors.Descriptor f7353g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f7354h = null;

    static {
        Descriptors.FileDescriptor r8 = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000enfcEvent.proto\u0012\u0017com.bytedance.nfc.proto\"C\n\bNfcProto\u00127\n\bnfcProto\u0018\u0001 \u0003(\u000b2%.com.bytedance.nfc.proto.NfcProtoData\"µ\u0006\n\fNfcProtoData\u0012-\n\u0005nfcOn\u0018\u0001 \u0001(\u000b2\u001e.com.bytedance.nfc.proto.NfcOn\u0012/\n\u0006nfcOff\u0018\u0002 \u0001(\u000b2\u001f.com.bytedance.nfc.proto.NfcOff\u0012E\n\u0011nfcPollingMessage\u0018\u0003 \u0001(\u000b2*.com.bytedance.nfc.proto.NfcPollingMessage\u0012A\n\u000fnfcActiveSEMode\u0018\u0004 \u0001(\u000b2(.com.bytedance.nfc.proto.NfcActiveSEMode\u0012=\n\rnfcHceMessage\u0018\u0005 \u0001(\u000b2&.com.bytedance.nfc.proto.NfcHceMessage\u0012A\n\u000fnfcErrorMessage\u0018\u0006 \u0001(\u000b2(.com.bytedance.nfc.proto.NfcErrorMessage\u0012A\n\u000fnfcCapabilities\u0018\u0007 \u0001(\u000b2(.com.bytedance.nfc.proto.NfcCapabilities\u0012=\n\tlifecycle\u0018\b \u0001(\u000b2*.com.bytedance.nfc.proto.NfcLifecycleEvent\u00121\n\u0003tag\u0018\t \u0001(\u000b2$.com.bytedance.nfc.proto.NfcTagEvent\u00129\n\u0007routing\u0018\n \u0001(\u000b2(.com.bytedance.nfc.proto.NfcRoutingEvent\u00124\n\u0005hceV2\u0018\u000b \u0001(\u000b2%.com.bytedance.nfc.proto.NfcHceEvent2\u0012/\n\u0002rf\u0018\f \u0001(\u000b2#.com.bytedance.nfc.proto.NfcRfEvent\u0012/\n\u0002ee\u0018\r \u0001(\u000b2#.com.bytedance.nfc.proto.NfcEeEvent\u00121\n\u0003ffd\u0018\u000e \u0001(\u000b2$.com.bytedance.nfc.proto.NfcFFDEvent\"E\n\u0005NfcOn\u0012\u000e\n\u0006nfc_on\u0018\u0001 \u0001(\t\u0012\u0019\n\u0011nfc_shutdown_mode\u0018\u0002 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(\u0003\",\n\u0006NfcOff\u0012\u000f\n\u0007nfc_off\u0018\u0001 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0002 \u0001(\u0003\"V\n\u0011NfcPollingMessage\u0012\u0014\n\fnfc_tag_type\u0018\u0001 \u0001(\t\u0012\u0018\n\u0010nfc_tag_schedule\u0018\u0002 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(\u0003\"@\n\u000fNfcActiveSEMode\u0012\u001a\n\u0012nfc_active_se_mode\u0018\u0001 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0002 \u0001(\u0003\"X\n\rNfcHceMessage\u0012\u000f\n\u0007nfc_aid\u0018\u0001 \u0001(\t\u0012#\n\u001bnfc_default_payment_service\u0018\u0002 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(\u0003\"T\n\u000fNfcErrorMessage\u0012\u0016\n\u000enfc_error_code\u0018\u0001 \u0001(\u0003\u0012\u0016\n\u000enfc_error_info\u0018\u0002 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(\u0003\"¸\u0001\n\u000fNfcCapabilities\u0012\u0017\n\u000fnfc_ese_support\u0018\u0001 \u0001(\t\u0012\u0017\n\u000fnfc_sim_support\u0018\u0002 \u0001(\t\u0012\u0017\n\u000fnfc_hce_support\u0018\u0003 \u0001(\t\u0012\u0016\n\u000enfc_fw_version\u0018\u0004 \u0001(\t\u0012\u0017\n\u000fnfc_nci_version\u0018\u0005 \u0001(\u0005\u0012\u0011\n\ttimestamp\u0018\u0006 \u0001(\u0003\u0012\u0016\n\u000endef_intercept\u0018\u0007 \u0001(\t\"¼\u0002\n\u0011NfcLifecycleEvent\u0012=\n\u0004type\u0018\u0001 \u0001(\u000e2/.com.bytedance.nfc.proto.NfcLifecycleEvent.Type\u0012\r\n\u0005state\u0018\u0002 \u0001(\u0005\u0012\u000e\n\u0006status\u0018\u0003 \u0001(\u0005\u0012\u0011\n\ttimestamp\u0018\u0004 \u0001(\u0003\"µ\u0001\n\u0004Type\u0012\u000b\n\u0007UNKNOWN\u0010\u0000\u0012\u0012\n\u000eENABLE_REQUEST\u0010\u0001\u0012\u0012\n\u000eENABLE_STARTED\u0010\u0002\u0012\u0013\n\u000fENABLE_FINISHED\u0010\u0003\u0012\u0013\n\u000fDISABLE_REQUEST\u0010\u0004\u0012\u0013\n\u000fDISABLE_STARTED\u0010\u0005\u0012\u0014\n\u0010DISABLE_FINISHED\u0010\u0006\u0012\u0010\n\fBOOT_STARTED\u0010\u0007\u0012\u0011\n\rBOOT_FINISHED\u0010\b\"½\u0002\n\u000bNfcTagEvent\u00127\n\u0004type\u0018\u0001 \u0001(\u000e2).com.bytedance.nfc.proto.NfcTagEvent.Type\u0012\u0011\n\tconnected\u0018\u0002 \u0001(\b\u0012\u0011\n\tisSkipped\u0018\u0003 \u0001(\b\u0012\u0013\n\u000bndefPayload\u0018\u0004 \u0001(\f\u0012\u0013\n\u000boemPackages\u0018\u0005 \u0003(\t\u0012\u0011\n\ttimestamp\u0018\u0006 \u0001(\u0003\u0012\f\n\u0004tech\u0018\u0007 \u0001(\t\u0012\u0010\n\bndefText\u0018\b \u0001(\t\"r\n\u0004Type\u0012\u000b\n\u0007UNKNOWN\u0010\u0000\u0012\u0011\n\rTAG_CONNECTED\u0010\u0001\u0012\u0010\n\fTAG_DISPATCH\u0010\u0002\u0012\r\n\tNDEF_READ\u0010\u0003\u0012\u0010\n\fNDEF_MESSAGE\u0010\u0004\u0012\u0017\n\u0013OEM_PACKAGE_EXTRACT\u0010\u0005\"Ç\u0001\n\u000fNfcRoutingEvent\u0012;\n\u0004type\u0018\u0001 \u0001(\u000e2-.com.bytedance.nfc.proto.NfcRoutingEvent.Type\u0012\u000f\n\u0007skipped\u0018\u0002 \u0001(\b\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(\u0003\"S\n\u0004Type\u0012\u000b\n\u0007UNKNOWN\u0010\u0000\u0012\u0011\n\rAPPLY_ROUTING\u0010\u0001\u0012\u0013\n\u000fROUTING_CHANGED\u0010\u0002\u0012\u0016\n\u0012ROUTING_TABLE_FULL\u0010\u0003\"\u008b\u0002\n\fNfcHceEvent2\u00128\n\u0004type\u0018\u0001 \u0001(\u000e2*.com.bytedance.nfc.proto.NfcHceEvent2.Type\u0012\u000b\n\u0003aid\u0018\u0002 \u0001(\t\u0012\u0010\n\bcategory\u0018\u0003 \u0001(\t\u0012\u000e\n\u0006action\u0018\u0004 \u0001(\u0005\u0012\u0011\n\tactivated\u0018\u0005 \u0001(\b\u0012\u0011\n\ttimestamp\u0018\u0006 \u0001(\u0003\u0012\u0013\n\u000bserviceName\u0018\u0007 \u0001(\t\"W\n\u0004Type\u0012\u000b\n\u0007UNKNOWN\u0010\u0000\u0012\r\n\tHCE_EVENT\u0010\u0001\u0012\u0012\n\u000eLAUNCH_CHOOSER\u0010\u0002\u0012\r\n\tTAP_AGAIN\u0010\u0003\u0012\u0010\n\fCE_ACTIVATED\u0010\u0004\"M\n\nNfcRfEvent\u0012\u0012\n\nrfDetected\u0018\u0001 \u0001(\b\u0012\u0018\n\u0010discoveryStarted\u0018\u0002 \u0001(\b\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(\u0003\"K\n\nNfcEeEvent\u0012\u0017\n\u000flistenActivated\u0018\u0001 \u0001(\b\u0012\u0011\n\teeUpdated\u0018\u0002 \u0001(\b\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(\u0003\"-\n\u000bNfcFFDEvent\u0012\u000b\n\u0003ffd\u0018\u0001 \u0001(\b\u0012\u0011\n\ttimestamp\u0018\u0002 \u0001(\u0003B\fB\bnfcEventP\u0001"}, new Descriptors.FileDescriptor[0]);
        new GeneratedMessageV3.FieldAccessorTable(r8.getMessageTypes().get(0), new String[]{"NfcProto"});
        new GeneratedMessageV3.FieldAccessorTable(r8.getMessageTypes().get(1), new String[]{"NfcOn", "NfcOff", "NfcPollingMessage", "NfcActiveSEMode", "NfcHceMessage", "NfcErrorMessage", "NfcCapabilities", "Lifecycle", "Tag", "Routing", "HceV2", "Rf", "Ee", "Ffd"});
        new GeneratedMessageV3.FieldAccessorTable(r8.getMessageTypes().get(2), new String[]{"NfcOn", "NfcShutdownMode", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
        new GeneratedMessageV3.FieldAccessorTable(r8.getMessageTypes().get(3), new String[]{"NfcOff", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
        new GeneratedMessageV3.FieldAccessorTable(r8.getMessageTypes().get(4), new String[]{"NfcTagType", "NfcTagSchedule", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
        new GeneratedMessageV3.FieldAccessorTable(r8.getMessageTypes().get(5), new String[]{"NfcActiveSeMode", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
        new GeneratedMessageV3.FieldAccessorTable(r8.getMessageTypes().get(6), new String[]{"NfcAid", "NfcDefaultPaymentService", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
        new GeneratedMessageV3.FieldAccessorTable(r8.getMessageTypes().get(7), new String[]{"NfcErrorCode", "NfcErrorInfo", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
        new GeneratedMessageV3.FieldAccessorTable(r8.getMessageTypes().get(8), new String[]{"NfcEseSupport", "NfcSimSupport", "NfcHceSupport", "NfcFwVersion", "NfcNciVersion", BwdlDropProvider.BwdlDropEntry.TIMESTAMP, "NdefIntercept"});
        Descriptors.Descriptor r10 = r8.getMessageTypes().get(9);
        f7347a = r10;
        f7348b = new GeneratedMessageV3.FieldAccessorTable(r10, new String[]{"Type", "State", BwdlDropProvider.BwdlDropEntry.STATUS, BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
        Descriptors.Descriptor r11 = r8.getMessageTypes().get(10);
        f7349c = r11;
        f7350d = new GeneratedMessageV3.FieldAccessorTable(r11, new String[]{"Type", "Connected", "IsSkipped", "NdefPayload", "OemPackages", BwdlDropProvider.BwdlDropEntry.TIMESTAMP, "Tech", "NdefText"});
        Descriptors.Descriptor r12 = r8.getMessageTypes().get(11);
        f7351e = r12;
        f7352f = new GeneratedMessageV3.FieldAccessorTable(r12, new String[]{"Type", "Skipped", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
        Descriptors.Descriptor r13 = r8.getMessageTypes().get(12);
        f7353g = r13;
        f7354h = new GeneratedMessageV3.FieldAccessorTable(r13, new String[]{"Type", "Aid", CaeProvider.CompatibilityEntry.CATEGORY, "Action", "Activated", BwdlDropProvider.BwdlDropEntry.TIMESTAMP, "ServiceName"});
        new GeneratedMessageV3.FieldAccessorTable(r8.getMessageTypes().get(13), new String[]{"RfDetected", "DiscoveryStarted", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
        new GeneratedMessageV3.FieldAccessorTable(r8.getMessageTypes().get(14), new String[]{"ListenActivated", "EeUpdated", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
        new GeneratedMessageV3.FieldAccessorTable(r8.getMessageTypes().get(15), new String[]{"Ffd", BwdlDropProvider.BwdlDropEntry.TIMESTAMP});
    }
}
