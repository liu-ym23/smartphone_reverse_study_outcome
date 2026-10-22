package com.larus.share.service;

import android.content.Context;
import android.widget.ImageView;
import com.larus.platform.api.IForwardCapabilityService;
import com.larus.platform.model.HandsfreeExperimentConfig;
import com.larus.share.impl.view.j0;
import com.larus.share.impl.view.k0;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0001(J\b\u0010\u0002\u001a\u00020\u0003H\u0016JZ\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00050\u000726\u0010\n\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00050\u000bH&J0\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH&J<\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\b2\u0006\u0010\u001d\u001a\u00020\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001f\u001a\u00020 H&J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0016J6\u0010$\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\tH&¨\u0006)"}, d2 = {"Lcom/larus/share/service/IShareDoubaoForwardService;", "Lcom/larus/platform/api/IForwardCapabilityService;", "isNativePickerAvailable", "", "requestRecentForwardList", "", "onSuccess", "Lkotlin/Function1;", "", "Lcom/larus/share/bean/DoubaoForwardTarget;", "onFailure", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errorCode", "", "errorMessage", "loadAvatar", "context", "Landroid/content/Context;", "avatarView", "Landroid/widget/ImageView;", "target", "width", "height", HandsfreeExperimentConfig.ASR_END_SEND, "doubaoMsgIds", "", "textContent", "targetInfos", "callback", "Lcom/larus/share/service/IShareDoubaoForwardService$SendCallback;", "openFileForwardPicker", "file", "Lcom/larus/bmhome/share/panel/HostForwardFileContent;", "sendFile", "note", "openForwardTarget", "targetInfo", "SendCallback", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IShareDoubaoForwardService extends IForwardCapabilityService {

    public interface a {
        void a(kw9.a r1);

        void onFailure(Integer r1, String r2);
    }

    void a(Context r1, ImageView r2, kw9.a r3, int r4, int r5);

    void b(Context r1, List r2, String r3, List r4, j0 r5);

    boolean c(Context r1, com.larus.bmhome.share.panel.c r2, String r3, List r4, k0 r5);

    boolean e(Context r1, kw9.a r2);

    boolean f(Context r1, com.larus.bmhome.share.panel.c r2);

    void g(Function1<? super List<kw9.a>, Unit> r1, Function2<? super Integer, ? super String, Unit> r2);
}
