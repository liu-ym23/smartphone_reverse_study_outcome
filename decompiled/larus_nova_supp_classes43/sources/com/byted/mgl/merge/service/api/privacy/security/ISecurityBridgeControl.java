package com.byted.mgl.merge.service.api.privacy.security;

import com.byted.cast.sink.api.IAPI;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH&J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH&J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&¨\u0006\r"}, d2 = {"Lcom/byted/mgl/merge/service/api/privacy/security/ISecurityBridgeControl;", "", "controlBridgeInvoke", "", BdpAwemeConstant.KEY_APP_ID, "", "bridgeName", "path", "getFreeBridgeList", "", "getValidateBridgeList", "preMatchByAppId", "", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public interface ISecurityBridgeControl {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
    public static final class DefaultImpls {
        public static /* synthetic */ void preMatchByAppId$default(ISecurityBridgeControl r0, String r1, String r10, int r11, Object r12) {
            if (r12 != null) goto L9;
            if ((r11 & 2) == 0) goto L6;
            r10 = null;
        L6:
            r0.preMatchByAppId(r1, r10);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preMatchByAppId");
        }

        public static /* synthetic */ boolean controlBridgeInvoke$default(ISecurityBridgeControl r0, String r1, String r10, String r11, int r12, Object r13) {
            if (r13 != null) goto L9;
            if ((r12 & 4) == 0) goto L7;
            r11 = null;
        L7:
            return r0.controlBridgeInvoke(r1, r10, r11);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: controlBridgeInvoke");
        }
    }

    boolean controlBridgeInvoke(String r1, String r10, String r11);

    List<String> getFreeBridgeList();

    List<String> getValidateBridgeList();

    void preMatchByAppId(String r1, String r10);
}
