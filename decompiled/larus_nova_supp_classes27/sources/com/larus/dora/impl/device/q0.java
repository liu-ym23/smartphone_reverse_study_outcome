package com.larus.dora.impl.device;

import android.view.View;
import android.widget.AdapterView;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoLayoutBinding;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q0 implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ DoraDeviceViewModel a;
    public final /* synthetic */ LarusDoraDeviceInfoLayoutBinding b;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> r1) {
    }

    public q0(DoraDeviceViewModel r1, LarusDoraDeviceInfoLayoutBinding r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> r1, View r2, int r3, long r4) {
        Keva r5 = DoraConfig.a;
        String r6 = (String) ListProtector.get(CollectionsKt.toList(this.a.getBots().keySet()), r3);
        Intrinsics.checkNotNullParameter(r6, "botId");
        DoraConfig.a.storeString("key_dora_main_bot_id", r6);
        Unit r7 = Unit.INSTANCE;
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L5;
        r8.m0("DoraConfig");
    L5:
        String r9 = this.a.getBots().get(DoraConfig.g());
        if (r9 != null) goto L8;
        r9 = "";
    L8:
        ItemTextArrow r10 = this.b.g;
        int r11 = ItemTextArrow.k;
        r10.Z5(r9, null);
        this.b.g.setVisible(true);
        this.a.reportBotSwitch(r9);
    }
}
