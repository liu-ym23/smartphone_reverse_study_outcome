package com.obric.aikernel.res.metadata.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0000\u001a(\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0000¨\u0006\f"}, d2 = {"resolveSealedFileAction", "Lcom/obric/aikernel/res/metadata/data/SealedFileAction;", "exists", "", "sizeMatches", "readOnly", "fastCheck", "requiresFullVerification", "shouldMigrateLegacyWritableModel", "managedModel", "sealedModel", "hasVerifiableArtifacts", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class h {
    public static final SealedFileAction a(boolean r0, boolean r1, boolean r2, boolean r3, boolean r4) {
        if (r0 == false) goto L15;
        if (r1 == false) goto L15;
        if (r3 == false) goto L9;
        if (r2 == false) goto L16;
        if (r4 == false) goto L9;
    L16:
        return SealedFileAction.DEFER_FULL_VERIFY;
    L9:
        if (r2 == false) goto L17;
        if (r4 == false) goto L19;
        return SealedFileAction.VERIFY;
    L19:
        return SealedFileAction.HEALTHY;
    L17:
        return SealedFileAction.VERIFY_AND_RESEAL;
    L15:
        return SealedFileAction.NEEDS_DOWNLOAD;
    }

    public static final boolean a(boolean r0, boolean r1, boolean r2, boolean r3) {
        if (r0 == false) goto L7;
        if (r1 == true) goto L7;
        if (r2 == true) goto L7;
        if (r3 == false) goto L7;
        return true;
    L7:
        return false;
    }
}
