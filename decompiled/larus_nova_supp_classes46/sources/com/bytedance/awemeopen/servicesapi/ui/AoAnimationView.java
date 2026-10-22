package com.bytedance.awemeopen.servicesapi.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0014\u0010\u0018B!\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u001aR\u001c\u0010\b\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "", "getRepeatMode", "()I", "setRepeatMode", "(I)V", "repeatMode", "getRepeatCount", "setRepeatCount", "repeatCount", "Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationServiceConfig;", "getConfig", "()Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationServiceConfig;", "setConfig", "(Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationServiceConfig;)V", "config", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ao_basic_service_api_release"}, k = 1, mv = {1, 7, 1})
public abstract class AoAnimationView extends AppCompatImageView implements Animatable {

    public static final class a {
    }

    static {
    }

    public abstract AoAnimationServiceConfig getConfig();

    public abstract int getRepeatCount();

    public abstract int getRepeatMode();

    public abstract void setConfig(AoAnimationServiceConfig r1);

    public abstract void setRepeatCount(int r1);

    public abstract void setRepeatMode(int r1);

    public AoAnimationView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
    }

    public AoAnimationView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        new LinkedHashMap();
        super(r2, r3);
    }

    public AoAnimationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        new LinkedHashMap();
        super(r2, r3, r4);
    }
}
