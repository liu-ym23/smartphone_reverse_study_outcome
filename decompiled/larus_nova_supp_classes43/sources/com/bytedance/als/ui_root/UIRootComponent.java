package com.bytedance.als.ui_root;

import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.als.LogicComponent;
import com.bytedance.als.b;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.objectcontainer.InjectAware;
import com.bytedance.objectcontainer.ObjectContainer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Deprecated(message = "don't use")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u00012\u00020\u00042\u00020\u0001R\u001b\u0010\n\u001a\u00020\u00058DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/als/ui_root/UIRootComponent;", "", "T", "Lcom/bytedance/als/LogicComponent;", "Lcom/bytedance/objectcontainer/InjectAware;", "Landroidx/appcompat/app/AppCompatActivity;", "activity$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", a.VALUE_ACTIVITY, "als_release"}, k = 1, mv = {1, 4, 1})
public abstract class UIRootComponent<T> extends LogicComponent<T> implements b, InjectAware {
    public static final /* synthetic */ KProperty[] c = null;

    static {
        c = new KProperty[]{Reflection.property1(new PropertyReference1Impl(UIRootComponent.class, a.VALUE_ACTIVITY, "getActivity()Landroidx/appcompat/app/AppCompatActivity;", 0))};
    }

    public final ObjectContainer a() {
        return null;
    }

    public final AppCompatActivity getActivity() {
        KProperty r0 = c[0];
        throw null;
    }

    @Override // com.bytedance.als.LogicComponent
    public final /* bridge */ /* synthetic */ b i() {
        return null;
    }
}
