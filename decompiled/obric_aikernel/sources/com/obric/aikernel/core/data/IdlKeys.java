package com.obric.aikernel.core.data;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class IdlKeys {
    public static final String Args_ApiDomain = "_AIKApiDomain";
    public static final String Args_ApiEntrance = "_AIKApiEntrance";
    public static final String Args_AppId = "_AppId";
    public static final String Args_BindExtraInfo = "_BindExtraInfo";
    public static final String Args_BindResumeSource = "_BindResumeSource";
    public static final String Args_BizName = "_BizName";
    public static final String Args_DownloadOnly = "_JustCheck";
    public static final String Args_Download_Model_Dur = "_DownloadModelDur";
    public static final String Args_Download_Model_Result = "_DownloadModelResult";
    public static final String Args_Download_Pkg_Dur = "_DownloadPkgDur";
    public static final String Args_Download_Pkg_Result = "_DownloadPkgResult";
    public static final String Args_End2EndCost = "_AIKE2ECost";
    public static final String Args_ExecuteTimeOut = "_AIKTaskTimeout";
    public static final String Args_Force_Execute = "_ForceExecute";
    public static final String Args_GrantFd = "_fd";
    public static final String Args_GrantUri = "_uri";
    public static final String Args_HostModels = "_HostModels";
    public static final String Args_IPCResult = "_IPCResult";
    public static final String Args_InferBinder = "_InferB";
    public static final String Args_Infer_Event = "_InferEvent";
    public static final String Args_Logid = "_LogId";
    public static final String Args_ModelCfg = "_ModelCfg";
    public static final String Args_ModelName = "_ModelName";
    public static final String Args_ModelScene = "_ModelScene";
    public static final String Args_ModelType = "_ModelType";
    public static final String Args_NoWait = "_RunNoWait";
    public static final String Args_PACKAGE_ARR = "_pkg_arr";
    public static final String Args_PackageName = "_PackageName";
    public static final String Args_Pkgs = "_BizPackages";
    public static final String Args_Priority = "_Priority";
    public static final String Args_ProcessedRet = "_AIKProcessedRet";
    public static final String Args_ReqTime = "_ReqTime";
    public static final String Args_SCENE = "_scene";
    public static final String Args_SdkVer = "_SdkVer";
    public static final String Args_SkipBindResume = "_SkipBindResume";
    public static final String Args_SourcePackageName = "_SourcePackageName";
    public static final String Args_SourcePackageUid = "_SourcePackageUid";
    public static final String Args_StreamingCall = "_SC";
    public static final String Args_TargetProcess = "_TargetProc";
    public static final String Args_TaskId = "_TaskId";
    public static final String Args_Time = "_Time";
    public static final String Args_Timeout = "_timeout";
    public static final String Args_TraceEventArgs = "_TraceEventArgs";
    public static final String Args_TraceEventKey = "_TraceEventKey";
    public static final String Args_TraceId = "_TraceId";
    public static final String Args_UseCloud = "_UseCloud";
    public static final String Call_Type = "_CT";
    public static final String Call_Type_CallBiz = "_CallBiz";
    public static final String Call_Type_CallGlobal = "_CallGlobal";
    public static final String Call_Type_CallGlobalBiz = "_CallGlobalBiz";
    public static final String Call_Type_CallModel = "_CallModel";
    public static final String Call_Type_CallScene = "_CallScene";
    public static final String ErrorCode = "_EC";
    public static final String ErrorInfo = "_EI";
    public static final IdlKeys INSTANCE = null;
    public static final String IsFinish = "_IF";
    public static final String IsTaskId = "_IT";
    public static final String MethodName = "_M";
    public static final String Method_CancelPreLoadPackage = "_CancelPreLoadPackage";
    public static final String Method_CancelTask = "_CancelTask";
    public static final String Method_CheckBiz = "_CheckBiz";
    public static final String Method_CheckBizInBatch = "_CheckBizInBatch";
    public static final String Method_ClearData = "_clearData";
    public static final String Method_ConnectWs = "_ConnectWs";
    public static final String Method_DownloadBiz = "_DownloadBiz";
    public static final String Method_EnumerateModels = "_EnumerateModels";
    public static final String Method_GetModel = "_GetModel";
    public static final String Method_GetModelByScene = "_GetModelByScene";
    public static final String Method_GetModelStatus = "_GetModelStatus";
    public static final String Method_GetModelStatusByScene = "_GetModelStatusByScene";
    public static final String Method_GetPackageRes = "_GetPkgRes";
    public static final String Method_GetScriptStatus = "_GetScriptStatus";
    public static final String Method_GrantUri = "_GrantUri";
    public static final String Method_LoadPackage = "_LoadPkg";
    public static final String Method_PreLoadPackage = "_Method_PreLoadPackage";
    public static final String Method_PushDebugPackage = "_PushDebugPackage";
    public static final String Method_QuerySubProc = "_QuerySubProc";
    public static final String Method_RunBiz = "_RunBiz";
    public static final String Method_SubProcRestart = "_RestartSubProc";
    public static final String Method_UnloadPackage = "_UnloadPkg";
    public static final String Method_UpdatePackages = "_UpdatePkgs";
    public static final String ModelMethodName = "_ModelMethod";
    public static final String Result = "_R";
    public static final String SubErrorCode = "_Sub_EC";

    static {
        INSTANCE = new IdlKeys();
    }

    private IdlKeys() {
    }
}
