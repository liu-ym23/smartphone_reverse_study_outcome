package com.obric.assistant.network.impl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/network/impl/ObricNetworkServiceImpl$OmniUploadPayloadKind;", "", "dataType", "", "dirName", "taskMarker", "defaultMime", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDataType", "()Ljava/lang/String;", "getDirName", "getTaskMarker", "getDefaultMime", "IMAGE", "VIEW_TREE", "REACT_VIEW_TREE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricNetworkServiceImpl$OmniUploadPayloadKind extends Enum<ObricNetworkServiceImpl$OmniUploadPayloadKind> {
    public static final ObricNetworkServiceImpl$OmniUploadPayloadKind IMAGE = null;
    public static final ObricNetworkServiceImpl$OmniUploadPayloadKind REACT_VIEW_TREE = null;
    public static final ObricNetworkServiceImpl$OmniUploadPayloadKind VIEW_TREE = null;
    public static final /* synthetic */ ObricNetworkServiceImpl$OmniUploadPayloadKind[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String dataType;
    private final String defaultMime;
    private final String dirName;
    private final String taskMarker;

    public static EnumEntries<ObricNetworkServiceImpl$OmniUploadPayloadKind> getEntries() {
        return b;
    }

    static {
        ObricNetworkServiceImpl$OmniUploadPayloadKind r7 = new ObricNetworkServiceImpl$OmniUploadPayloadKind("IMAGE", 0, "image", "omni_upload_images", "_00_omni_upload_task_", "image/jpeg");
        IMAGE = r7;
        ObricNetworkServiceImpl$OmniUploadPayloadKind r0 = new ObricNetworkServiceImpl$OmniUploadPayloadKind("VIEW_TREE", 1, "view_tree", "omni_upload_viewtrees", "_00_omni_upload_vt_task_", "application/json");
        VIEW_TREE = r0;
        ObricNetworkServiceImpl$OmniUploadPayloadKind r1 = new ObricNetworkServiceImpl$OmniUploadPayloadKind("REACT_VIEW_TREE", 2, "react_view_tree", "omni_upload_react_view_tree", "_00_omni_upload_react_view_tree_task_", "application/json");
        REACT_VIEW_TREE = r1;
        ObricNetworkServiceImpl$OmniUploadPayloadKind[] r2 = {r7, r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static ObricNetworkServiceImpl$OmniUploadPayloadKind[] values() {
        return (ObricNetworkServiceImpl$OmniUploadPayloadKind[]) a.clone();
    }

    public final String getDataType() {
        return this.dataType;
    }

    public final String getDefaultMime() {
        return this.defaultMime;
    }

    public final String getDirName() {
        return this.dirName;
    }

    public final String getTaskMarker() {
        return this.taskMarker;
    }

    public static ObricNetworkServiceImpl$OmniUploadPayloadKind valueOf(String r1) {
        return (ObricNetworkServiceImpl$OmniUploadPayloadKind) a.a(ObricNetworkServiceImpl$OmniUploadPayloadKind.class, r1);
    }

    public ObricNetworkServiceImpl$OmniUploadPayloadKind(String r1, int r2, String r3, String r4, String r5, String r6) {
        super(r1, r2);
        this.dataType = r3;
        this.dirName = r4;
        this.taskMarker = r5;
        this.defaultMime = r6;
    }
}
