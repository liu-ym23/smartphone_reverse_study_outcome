package com.bytedance.awemeopen.infra.base.anim.lottie;

import com.bytedance.awemeopen.servicesapi.ui.AoAnimationService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationService;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AoAnim$aoAnimService$2 extends Lambda implements Function0<AoAnimationService> {
    public static final AoAnim$aoAnimService$2 INSTANCE = null;

    static {
        INSTANCE = new AoAnim$aoAnimService$2();
    }

    public AoAnim$aoAnimService$2() {
        super(0);
    }

    public final AoAnimationService invoke() {
        int r0 = j64.b.a;
        return j64.b.a(AoAnimationService.class);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m879invoke() {
        return invoke();
    }
}
