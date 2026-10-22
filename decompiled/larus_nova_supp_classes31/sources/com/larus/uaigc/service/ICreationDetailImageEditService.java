package com.larus.uaigc.service;

import android.app.Activity;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.platform.model.creation.ResourceExt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&Jf\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\bH&¨\u0006\u001b"}, d2 = {"Lcom/larus/uaigc/service/ICreationDetailImageEditService;", "", "buildSingleImageRefInfo", "", "Lcom/larus/platform/model/creation/ResourceExt;", "previewUrl", "", "openDetailEditPage", "", "activity", "Landroid/app/Activity;", "payload", "Lcom/larus/uaigc/bean/chat/gallery/CreationDetailImageEditHelper$DetailImagePayload;", "hitPointData", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lcom/larus/bmhome/view/actionbar/custom/bean/CustomActionBarItem;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "selectInstructionType", "", "openNewChatPage", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "ignoreSideBar", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ICreationDetailImageEditService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J]\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\nH\u0096\u0001¨\u0006\u001c"}, d2 = {"Lcom/larus/uaigc/service/ICreationDetailImageEditService$Companion;", "Lcom/larus/uaigc/service/ICreationDetailImageEditService;", "<init>", "()V", "buildSingleImageRefInfo", "", "Lcom/larus/platform/model/creation/ResourceExt;", "previewUrl", "", "openDetailEditPage", "", "activity", "Landroid/app/Activity;", "payload", "Lcom/larus/uaigc/bean/chat/gallery/CreationDetailImageEditHelper$DetailImagePayload;", "hitPointData", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lcom/larus/bmhome/view/actionbar/custom/bean/CustomActionBarItem;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "selectInstructionType", "", "openNewChatPage", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "ignoreSideBar", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements ICreationDetailImageEditService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ ICreationDetailImageEditService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationDetailImageEditService
        public final List<ResourceExt> a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "previewUrl");
            return this.b.a(r2);
        }

        @Override // com.larus.uaigc.service.ICreationDetailImageEditService
        public final boolean b(Activity r12, com.larus.uaigc.bean.chat.gallery.a.C0037a r13, zs8.a r14, z0 r15, ChatParam r16, int r17, boolean r18, by7.e r19, boolean r20) {
            Intrinsics.checkNotNullParameter(r12, "activity");
            Intrinsics.checkNotNullParameter(r13, "payload");
            Intrinsics.checkNotNullParameter(r14, "hitPointData");
            return this.b.b(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        private Companion() {
            this.b = (ICreationDetailImageEditService) ServiceManager.get().getService(ICreationDetailImageEditService.class);
        }
    }

    static {
        a = Companion.c;
    }

    List<ResourceExt> a(String r1);

    boolean b(Activity r1, com.larus.uaigc.bean.chat.gallery.a.C0037a r2, zs8.a r3, z0 r4, ChatParam r5, int r6, boolean r7, by7.e r8, boolean r9);
}
