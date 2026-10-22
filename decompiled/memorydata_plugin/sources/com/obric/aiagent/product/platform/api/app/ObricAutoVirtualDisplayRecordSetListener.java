package com.obric.aiagent.product.platform.api.app;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u000e"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener;", "", "<init>", "()V", "onPackageAdmitted", "", ObricMemoryConstants.KEY_SESSION_ID, "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "onRecordSetClosed", InfoRequestQPSOptTraceLogger.REASON, "", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ObricAutoVirtualDisplayRecordSetListener {
    public static final Companion Companion = null;
    public static final int RECORD_SET_CLOSE_REASON_DISPLAY_REMOVED = 2;
    public static final int RECORD_SET_CLOSE_REASON_ENDED = 1;
    public static final int RECORD_SET_CLOSE_REASON_REPLACED = 4;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener$Companion;", "", "<init>", "()V", "RECORD_SET_CLOSE_REASON_ENDED", "", "RECORD_SET_CLOSE_REASON_DISPLAY_REMOVED", "RECORD_SET_CLOSE_REASON_REPLACED", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ObricAutoVirtualDisplayRecordSetListener() {
    }

    public abstract void onPackageAdmitted(long r1, String r3);

    public abstract void onRecordSetClosed(long r1, int r3);
}
