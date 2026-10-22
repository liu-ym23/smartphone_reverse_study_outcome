package com.bytedance.ai.resource.core;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup", f = "AIPackageOperationGroup.kt", i = {0, 0, 0, 0}, l = {409}, m = "loadManifestBean", n = {"this", "deploymentInfo", STGroup.DICT_KEY, "job"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class AIPackageOperationGroup$loadManifestBean$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AIPackageOperationGroup f2592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AIPackageDeployment.AIPackageDeploymentItem f2593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2594c;
    public m0 d;
    public /* synthetic */ Object e;
    public final /* synthetic */ AIPackageOperationGroup f;
    public int g;

    public AIPackageOperationGroup$loadManifestBean$1(AIPackageOperationGroup r5, ContinuationImpl r10) {
        this.f = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.e = r5;
        this.g |= Integer.MIN_VALUE;
        return this.f.a(null, this);
    }
}
