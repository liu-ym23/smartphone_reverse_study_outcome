package com.obric.memorydata.memory.ui.address.edit;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/AddressEditViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "type", "", "<init>", "(Ljava/lang/String;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AddressEditViewModelFactory implements ViewModelProvider.Factory {
    private final String type;

    public AddressEditViewModelFactory(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.type = r2;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "modelClass");
        if (r2.isAssignableFrom(AddressEditViewModel.class) == false) goto L7;
        return (T) ZeusTransformUtils.preCheckCast(new AddressEditViewModel(this.type), ViewModel.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
