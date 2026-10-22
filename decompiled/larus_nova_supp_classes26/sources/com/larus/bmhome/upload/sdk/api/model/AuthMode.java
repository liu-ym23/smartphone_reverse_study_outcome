package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/AuthMode;", "", "<init>", "(Ljava/lang/String;I)V", "ResourceCenterPrepareUpload", "UploadAuthToken", "ProvidedCredential", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AuthMode extends Enum<AuthMode> {
    public static final AuthMode ProvidedCredential = null;
    public static final AuthMode ResourceCenterPrepareUpload = null;
    public static final AuthMode UploadAuthToken = null;
    public static final /* synthetic */ AuthMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AuthMode> getEntries() {
        return b;
    }

    static {
        AuthMode r0 = new AuthMode("ResourceCenterPrepareUpload", 0);
        ResourceCenterPrepareUpload = r0;
        AuthMode r1 = new AuthMode("UploadAuthToken", 1);
        UploadAuthToken = r1;
        AuthMode r3 = new AuthMode("ProvidedCredential", 2);
        ProvidedCredential = r3;
        AuthMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AuthMode[] values() {
        return (AuthMode[]) a.clone();
    }

    public static AuthMode valueOf(String r1) {
        return (AuthMode) a.a(AuthMode.class, r1);
    }

    public AuthMode(String r1, int r2) {
        super(r1, r2);
    }
}
