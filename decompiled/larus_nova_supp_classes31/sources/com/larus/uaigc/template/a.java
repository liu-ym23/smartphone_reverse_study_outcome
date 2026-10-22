package com.larus.uaigc.template;

import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.larus.bmhome.creative.utils.ImageTemplateChooseViewModel;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.uaigc.createpage.CreationActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class a implements Function3 {
    public final /* synthetic */ AppCompatActivity a;

    public /* synthetic */ a(CreationActivity r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10, Object r11, Object r12) {
        AppCompatActivity r0 = this.a;
        TemplateInfo$TemplateInfo r2 = (TemplateInfo$TemplateInfo) r10;
        Uri r13 = (Uri) r12;
        Intrinsics.checkNotNullParameter(r2, "templateInfo");
        new ViewModelProvider(r0).get(ImageTemplateChooseViewModel.class).onImageTemplateChoose(new com.larus.bmhome.creative.utils.b(r2, (String) r11, true, null, null, false, 56));
        return Unit.INSTANCE;
    }
}
